package com.tlm.people.dao;

import com.tlm.people.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionDao {

    //查询所有
    List<User> findAll();
}
