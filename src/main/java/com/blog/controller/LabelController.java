package com.blog.controller;

import com.blog.entity.Label;
import com.blog.service.LabelService;
import com.blog.util.result.Code;
import com.blog.util.result.Result;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping("labels")
    @ResponseBody
    public Result getLabel(){
        List<Label> labelList= labelService.getLabelList();
        Gson gson = new Gson();
        String jsonElement = gson.toJson(labelList);
        Result result = new Result();
        result.setCode(Code.SUCCESS.getCode());
        result.setMsg(Code.SUCCESS.getMsg());
        result.setData(jsonElement);
        return result;
    }

    @PutMapping("label")
    @ResponseBody
    public Result addLabel(Label label){
        int res = labelService.insertLabel(label);
        Result result = new Result();
        if(res == 1){
            result.setCode(Code.SUCCESS.getCode());
            result.setMsg(Code.SUCCESS.getMsg());
        }else{
            result.setCode(Code.FAILED.getCode());
            result.setMsg(Code.FAILED.getMsg());
        }
        return result;
    }

    @PostMapping("label")
    @ResponseBody
    public Result updateLabel(Label label){
        int res = labelService.updateLabel(label);
        Result result = new Result();
        if(res == 1){
            result.setCode(Code.SUCCESS.getCode());
            result.setMsg(Code.SUCCESS.getMsg());
        }else{
            result.setCode(Code.FAILED.getCode());
            result.setMsg(Code.FAILED.getMsg());
        }
        return result;
    }

    @PostMapping("label/delete")
    @ResponseBody
    public Result deleteLabel(Label label){
        int id = label.getId();
        System.out.println(id);
        int res = labelService.deleteLabel(Integer.valueOf(id));
        Result result = new Result();
        if(res == 1){
            result.setCode(Code.SUCCESS.getCode());
            result.setMsg(Code.SUCCESS.getMsg());
        }else if(2 == res){
            result.setCode(Code.FAILED.getCode());
            result.setMsg("标签已使用禁止删除");
        }else{
            result.setCode(Code.FAILED.getCode());
            result.setMsg(Code.FAILED.getMsg());
        }
        return result;
    }


}
