package com.tlm.people.entity.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionExcelBo {

    @ExcelProperty(value = "学号" ,index = 0)
    private Long stuId;

    @ExcelProperty(value = "姓名" ,index = 1)
    private String stuName;

    @ExcelProperty(value = "姓名" ,index = 2)
    private Integer status;

}
