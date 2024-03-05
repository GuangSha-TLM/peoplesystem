package com.tlm.people.service.impl;

import com.alibaba.excel.EasyExcel;
import com.tlm.people.dao.FunctionDao;
import com.tlm.people.entity.vo.FunctionExcelVo;
import com.tlm.people.service.FunctionService;
import com.tlm.people.utils.ExcelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

}
