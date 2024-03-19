package com.tlm.people.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;

public class FunctionExcelVo1 {
    private Long id;
    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    public FunctionExcelVo1(){}

    public FunctionExcelVo1(Long id, Long stuId, String stuName) {
        this.id = id;
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "FunctionExcelVo1{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
