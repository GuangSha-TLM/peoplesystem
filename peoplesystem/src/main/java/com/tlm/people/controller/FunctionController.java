package com.tlm.people.controller;

import com.alibaba.fastjson2.JSONArray;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.result.Result;
import com.tlm.people.service.FunctionService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tlm/people/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    //上传文件
    @ApiOperation("上传文件")
    @PostMapping("/importData")
    public String importData(MultipartFile multipartFile) {
        functionService.importData(multipartFile);
        return JSONArray.toJSONString(new ResponseVo("上传成功",null,"0x200"));
    }
    //上传文件1
    @ApiOperation("上传文件1")
    @PostMapping("/importData1/{id}")
    public String importData1( MultipartFile multipartFile, @PathVariable Long id) {

        this.functionService.importData1(multipartFile,id);
       return JSONArray.toJSONString(new ResponseVo("上传成功", null, "0x200"));
    }
    //导出
    @ApiOperation("文件下载")
    @GetMapping("/exportData")
    public String exportData(HttpServletResponse response) {
        functionService.exportData(response);
        return JSONArray.toJSONString(new ResponseVo("下载成功",null,"0x200"));
    }

    //下载指定状态（抽中/未抽中）的所有人的数据
    @ApiOperation("下载指定状态的数据")
    @PostMapping("/exportStatusData/{status}")
    public String exportStatusData(HttpServletResponse response,@PathVariable Integer status){
        functionService.exportStatusData(response,status);
        return JSONArray.toJSONString(new ResponseVo("下载成功",null,"0x200"));
    }

    //摇人文件下载
    @ApiOperation("摇人文件下载")
    @GetMapping("/exportDataShake")
    public String exportDataShake(HttpServletResponse response,@RequestParam List<Long> shakeIdList) {
        functionService.exportDataShake(response, shakeIdList);
        return JSONArray.toJSONString(new ResponseVo("下载成功",null,"0x200"));
    }
}
