package com.blog.dao;

import com.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> getArticleList(@Param("startRow") int startRow,@Param("pageSize") int pageSize);

    List<Article> getArticleLists(@Param("keyword") String keyword
            ,@Param("type") String type
            ,@Param("beginTime")int beginTime
            ,@Param("endTime") int endTime
            ,@Param("startRow") int startRow);

    @Select("select LAST_INSERT_ID()")
    int getLastId();
}