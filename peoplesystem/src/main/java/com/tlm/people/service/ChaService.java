package com.tlm.people.service;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.vo.ResponseVo;

import java.util.List;

public interface ChaService {
    /**
     * 通过id查询通道
     * @param id
     * @return
     */
    Cha selectByChaId(Long id);

    /**
     * 查询所有通道
     * @return
     */
    List<Cha> findAll();

    /**
     * 添加通道
     * @param cha
     * @return
     */
    Cha insertByCha(Cha cha);

    /**
     * 修改通道
     * @param cha
     * @return
     */
    Cha updateByCha(Cha cha);

    /**
     * 删除通道
     * @param id
     * @return
     */
    boolean delecteByChaId(Long id);
}
