package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;
import com.blog.util.file.FileUtil;
import com.blog.util.result.Code;
import com.blog.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 添加文章
     * @param article
     * @param img
     * @param label
     * @return
     */
    @PostMapping("article")
    @ResponseBody
    public Result addArticle(Article article,String img,String label){

        int res = articleService.addArticle(article,img,label);
        System.out.println(res);
        System.out.println(img);
        Result result = new Result();
        if(res >= 1){
            result.setCode(Code.SUCCESS.getCode());
            result.setMsg(Code.SUCCESS.getMsg());
        }else{
            result.setCode(Code.FAILED.getCode());
            result.setMsg(Code.FAILED.getMsg());
        }
        return result;
    }

    /**
     * 获取上传配置
     * @param res
     */
    @GetMapping("config")
    public void getUploadImgConfig(HttpServletResponse res){
        //中文乱码
        res.setContentType("text/html;charset=gbk");

        PrintWriter pw= null;
        BufferedReader bw = null;
        try {
            pw = res.getWriter();
            FileReader f=new FileReader( ResourceUtils.getFile("classpath:config.json"));
            bw = new BufferedReader(f);
            String config = "";
            do{
                config += bw.readLine();
            }while (bw.read() != -1);
            pw.println(config);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 文章图片上传
     */
    @PostMapping("config")
    @ResponseBody
    public String uploadImg(MultipartFile mfile,HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("upfile");
        System.out.println(files.size());
        MultipartFile file = files.get(0);
        String contentType = file.getContentType();
        String fileName = createFileName(file.getOriginalFilename());
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
//	        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//	        System.out.println(filePath);
        String filePath = "d://imgupload/";
//        int res = goodsDao.addGoodsImg(goodsId, fileName, String.valueOf(System.currentTimeMillis()), "");
        try {
                FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Result result = new Result();
//        result.setCode(1);
//        result.setMsg(filePath+fileName);
        String result = "{" +
                "    \"state\": \"SUCCESS\"," +
                "    \"url\": "+"\"http://localhost/picture/"+fileName+"\","+
                "    \"title\": \"" +fileName+"\","+
                "    \"original\":\"" + file.getOriginalFilename()+
                "\"}";
        return result;
    }

    @GetMapping("articles")
    @ResponseBody
    public Result getArticleList(@RequestParam(defaultValue = "",required = false) String keyword
                , @RequestParam(defaultValue = "",required = false)String type
                , @RequestParam(defaultValue = "",required = false)String beginTime
            , @RequestParam(defaultValue = "",required = false)String endTime
            , @RequestParam(defaultValue = "",required = false)int pageNum){
        Result result = new Result();
        try {
            List<Article> list = null;
            if(StringUtils.isEmpty(beginTime)){
                list = articleService.getArticleList(keyword,type,0
                        ,0,pageNum);
            }
            result.setCode(Code.SUCCESS.getCode());
            result.setData(list);
        }catch (Exception e){
            result.setCode(Code.FAILED.getCode());
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @GetMapping("article")
    @ResponseBody
    public Result getArticleList(Integer articleId){
        Result result = new Result();
        try {
            Article article = articleService.getArticleDetail(articleId);
            result.setCode(Code.SUCCESS.getCode());
            result.setData(article);
        }catch (Exception e){
            result.setCode(Code.FAILED.getCode());
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    private String createFileName(String originFileName) {
        String[] temp = originFileName.split("\\.");
        String newName = UUID.randomUUID().toString().replaceAll("-", "");
        return newName + "." + temp[temp.length-1];
    }
}
