package com.blog.dao;

import com.blog.entity.Viewer;

public interface ViewerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Viewer record);

    int insertSelective(Viewer record);

    Viewer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Viewer record);

    int updateByPrimaryKey(Viewer record);
}