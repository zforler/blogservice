package com.blog.dao;

import com.blog.entity.ArticleImg;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

public interface ArticleImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleImg record);

    int insertBench(@Param("imgUrl") String[] imgUrl,@Param("articleId")
            String articleId,@Param("createTime")String createTime);

    int insertSelective(ArticleImg record);

    ArticleImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleImg record);

    int updateByPrimaryKey(ArticleImg record);
}