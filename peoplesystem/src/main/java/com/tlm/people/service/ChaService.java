package com.tlm.people.service;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.vo.ResponseVo;

import java.util.List;

public interface ChaService {
    Cha selectByChaId(Long id);
    List<Cha> findAll();
    Cha insertByCha(Cha cha);
    Cha updateByCha(Cha cha);
    boolean delecteByChaId(Long id);
}
