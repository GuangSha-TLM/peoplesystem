package com.tlm.people.service;

import org.springframework.web.multipart.MultipartFile;

public interface FunctionService {

    //文件上传
    void importData(MultipartFile multipartFile);
}
