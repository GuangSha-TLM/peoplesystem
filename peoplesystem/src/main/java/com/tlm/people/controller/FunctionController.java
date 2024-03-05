package com.tlm.people.controller;

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
    public Result importData(MultipartFile multipartFile) {
        functionService.importData(multipartFile);
        return Result.ok();
    }

    //导出
    @GetMapping("/exportData")
    public Result exportData(HttpServletResponse response) {
        functionService.exportData(response);
        return Result.ok();
    }

}
