package com.blog.service;

import com.blog.dao.ArticleLabelMapper;
import com.blog.dao.ArticleMapper;
import com.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleImgService articleImgService;
    @Autowired
    ArticleLabelMapper articleLabelMapper;

    /**
     * 添加文章
     * @param article
     * @param imgUrl
     * @param label
     * @return
     */
    @Transactional
    public int addArticle(Article article, String imgUrl, String label) {
        int res = articleMapper.insert(article);
        if (res == 1) {
            int articleId = articleMapper.getLastId();
            res = articleImgService.insertImg(imgUrl, articleId);
            String[] labelIds = label.split(",");
            res = articleLabelMapper.insertLabels(labelIds, articleId);
        }
        return res;
    }

    /**
     * 分页获取文章列表
     * @param keyword
     * @param type
     * @param beginTime
     * @param endTime
     * @param pageNum
     * @return
     */
    public List<Article> getArticleList(String keyword, String type, int beginTime, int endTime, int pageNum) {
        return articleMapper.getArticleList(pageNum * 20, 20);
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    public Article getArticleDetail(Integer articleId){
        return articleMapper.selectByPrimaryKey(articleId);
    }
}