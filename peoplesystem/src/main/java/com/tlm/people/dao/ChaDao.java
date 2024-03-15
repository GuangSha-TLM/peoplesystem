package com.tlm.people.dao;

import com.tlm.people.entity.Cha;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChaDao {
    Cha selectByChaId (Long id);
    List<Cha> findAll();
    int insertByCha(Cha cha);
    int updateByCha(Cha cha);
    int deleteByChaId (Long id);
}
