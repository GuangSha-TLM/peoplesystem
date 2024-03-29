package com.tlm.people.dao;

import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.FunctionExcelVo;
import com.tlm.people.entity.vo.FunctionExcelVo1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FunctionMapper {

    //查询所有
    List<Stu> findAll();

    //写入
    List<Stu> importData();

    //插入数据到数据库(上传文件)
    void saveData(List<FunctionExcelVo> cachedDataList);

    void saveData1(List<FunctionExcelVo1> cachedDataList);
    //批量查询
    List<Stu> selectShake(List<Long> shakeIdList);

    //根据状态找出所有stu对象
    List<Stu> selectAllStatus(Integer status);
}





