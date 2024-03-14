package com.tlm.people.dao;

import com.tlm.people.entity.Cha;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChaDao {
    Cha selectByChaId (Long id);
    int insertByCha(Cha cha);
    int updateByCha(Cha cha);
    int deleteByChaId (Long id);
}
