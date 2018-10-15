package com.blog.service;

import com.blog.dao.ArticleLabelMapper;
import com.blog.dao.LabelMapper;
import com.blog.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {

    @Autowired
    LabelMapper labelMapper;



    public List<Label> getLabelList(){
        return labelMapper.getLabelList();
    }

    public int insertLabel(Label label){
        return labelMapper.insert(label);
    }

    public int updateLabel(Label label){
        return labelMapper.updateByPrimaryKey(label);
    }

    public int deleteLabel(int id){
        int res = labelMapper.findUse(id);
        if(res >= 1){
            return 2;
        }
        res = labelMapper.deleteByPrimaryKey(id);
        return res;
    }
}
