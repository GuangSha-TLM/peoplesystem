package com.tlm.people.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.tlm.people.entity.Stu;

public class FunctionExcelVo1 {
    @ExcelProperty(value = "学号", index = 0)
    private Long stuId;
    @ExcelProperty(value = "姓名", index = 1)
    private String stuName;
    @ExcelProperty(value = "通道", index = 2)
    private Long channelId;

    public FunctionExcelVo1() {
    }

    public FunctionExcelVo1(Long stuId, String stuName, Long channelId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.channelId = channelId;
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "FunctionExcelVo1{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", channelId=" + channelId +
                '}';
    }
}
