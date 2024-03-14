package com.tlm.people.dao;

import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.FunctionExcelVo;
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
    //批量查询
    List<Stu> selectShake(List<Long> shakeIdList);

}
