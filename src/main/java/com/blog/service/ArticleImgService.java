package com.blog.service;


import com.blog.dao.ArticleImgMapper;
import com.blog.entity.ArticleImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ArticleImgService {
    @Autowired
    ArticleImgMapper articleImgMapper;

    public int benchAddImg(String[] imgUrl,String articleId){
        long createTime = Instant.now().getEpochSecond();
        int res = articleImgMapper.insertBench(imgUrl,articleId,String.valueOf(createTime));
        return res;
    }

    public int insertImg(String url,int articleId){
        ArticleImg articleImg = new ArticleImg();
        articleImg.setArticleid(articleId);
        articleImg.setUrl(url);
        long createTime = Instant.now().getEpochSecond();
        articleImg.setCreatetime(String.valueOf(createTime));
        int res = articleImgMapper.insert(articleImg);
        return res;
    }
}
