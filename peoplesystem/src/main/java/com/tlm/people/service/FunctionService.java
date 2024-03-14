package com.tlm.people.service;

import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public interface FunctionService {

    //文件上传
    void importData(MultipartFile multipartFile);

    //文件导出（下载）
    void exportData(HttpServletResponse response);

    //摇人后下载
    void exportDataShake(HttpServletResponse response , List<Long> shakeList);

}
