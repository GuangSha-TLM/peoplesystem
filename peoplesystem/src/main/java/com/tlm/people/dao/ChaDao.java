package com.tlm.people.dao;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChaDao {
    /**
     * 根据id查询通道名
     * @param id
     * @return
     */
    Cha selectByChaId (Long id);

    /**
     * 查看所有通道
     * @return
     */
    List<Cha> findAll();

    /**
     * 添加通道
     * @param cha
     * @return
     */
    int insertByCha(Cha cha);

    /**
     * 修改通道
     * @param cha
     * @return
     */
    int updateByCha(Cha cha);

    /**
     * 删除通道
     * @param id
     * @return
     */
    int deleteByChaId (Long id);
}
