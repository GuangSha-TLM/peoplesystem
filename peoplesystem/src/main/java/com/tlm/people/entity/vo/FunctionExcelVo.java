package com.tlm.people.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;

public class FunctionExcelVo {
    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    public FunctionExcelVo(){}

    public FunctionExcelVo(Long stuId, String stuName) {
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "FunctionExcelVo{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
