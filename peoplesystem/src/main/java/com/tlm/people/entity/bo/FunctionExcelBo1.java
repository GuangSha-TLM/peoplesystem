package com.tlm.people.entity.bo;

import com.alibaba.excel.annotation.ExcelProperty;

public class FunctionExcelBo1 {
    private Long id;
    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    @ExcelProperty(value = "状态" ,index = 2)
    private Integer status;

    public FunctionExcelBo1() {}

    public FunctionExcelBo1(Long id, Long stuId, String stuName, Integer status) {
        this.id = id;
        this.stuId = stuId;
        this.stuName = stuName;
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FunctionExcelBo1{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", status=" + status +
                '}';
    }
}
