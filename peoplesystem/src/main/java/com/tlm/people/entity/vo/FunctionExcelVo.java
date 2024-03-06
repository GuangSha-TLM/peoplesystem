package com.tlm.people.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionExcelVo {

    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

}
