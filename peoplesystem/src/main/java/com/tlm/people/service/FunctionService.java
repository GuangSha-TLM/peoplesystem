package com.tlm.people.service;

import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public interface FunctionService {

    //文件上传
    void importData(MultipartFile multipartFile);
    //文件上传2
    void importData1(MultipartFile multipartFile, ChaWithStu chaWithStu);
    //文件导出（下载）
    void exportData(HttpServletResponse response);

    //摇人后下载
    void exportDataShake(HttpServletResponse response , List<Long> shakeList);

    /**
     * @author hln 2024-3-17
     * 下载指定状态（抽中/未抽中）的所有人的数据
     * @param response
     * @param status
     */
    void exportStatusData(HttpServletResponse response, Integer status);
}
