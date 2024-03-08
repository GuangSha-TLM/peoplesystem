package com.tlm.people.controller;

import com.alibaba.fastjson2.JSONArray;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.result.Result;
import com.tlm.people.service.FunctionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tlm/people/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    //上传文件
    @ApiOperation("上传文件")
    @PostMapping("/importData")
    public String importData(MultipartFile multipartFile) {
        return JSONArray.toJSONString(functionService.importData(multipartFile));
    }

    //导出
    @ApiOperation("文件下载")
    @GetMapping("/exportData")
    public String exportData(HttpServletResponse response) {
        functionService.exportData(response);
        return JSONArray.toJSONString(new ResponseVo("下载成功",null,"0x200"));
    }


}
