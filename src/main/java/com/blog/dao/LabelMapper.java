package com.blog.dao;

import com.blog.entity.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);

    int findUse(@Param("id") int id);

    List<Label> getLabelList();
}