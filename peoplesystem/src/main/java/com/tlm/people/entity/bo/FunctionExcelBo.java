package com.tlm.people.entity.bo;

import com.alibaba.excel.annotation.ExcelProperty;

public class FunctionExcelBo {

    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    @ExcelProperty(value = "状态" ,index = 2)
    private Integer status;

    public FunctionExcelBo() {}

    public FunctionExcelBo(Long stuId, String stuName, Integer status) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FunctionExcelBo{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", status=" + status +
                '}';
    }
}
