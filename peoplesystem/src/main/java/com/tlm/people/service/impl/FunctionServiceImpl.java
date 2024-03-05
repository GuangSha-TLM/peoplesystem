package com.tlm.people.service.impl;

import com.alibaba.excel.EasyExcel;
import com.tlm.people.dao.FunctionDao;
import com.tlm.people.entity.vo.FunctionExcelVo;
import com.tlm.people.service.FunctionService;
import com.tlm.people.utils.ExcelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionDao functionDao;

    @Override
    public void importData(MultipartFile multipartFile) {

        ExcelListener<FunctionExcelVo> excelListener = new ExcelListener<FunctionExcelVo>(functionDao);

        try{
            EasyExcel.read(multipartFile.getInputStream(), FunctionExcelVo.class,excelListener)
                    .sheet().doRead();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //文件导出（下载）
    @Override
    public void exportData(HttpServletResponse response) {
        try{
            //设置响应头信息和其他信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            //防止乱码
            String fileName = URLEncoder.encode("分类数据", "UTF-8");

            //设置响应头
            response.setHeader("Content-disposition","filename=" + fileName + ".xlsx");

            //

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
