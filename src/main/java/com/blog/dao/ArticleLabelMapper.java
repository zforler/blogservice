package com.blog.dao;

import com.blog.entity.ArticleLabel;
import org.apache.ibatis.annotations.Param;

public interface ArticleLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleLabel record);

    int insertSelective(ArticleLabel record);

    ArticleLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleLabel record);

    int updateByPrimaryKey(ArticleLabel record);

    int insertLabels(@Param("labelIds") String[] ids, @Param("articleId") int articleId);
}