package com.tlm.people.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FunctionService {

    //文件上传
    void importData(MultipartFile multipartFile);

    //文件导出（下载）
    void exportData(HttpServletResponse response);
}
