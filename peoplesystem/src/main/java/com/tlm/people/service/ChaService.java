package com.tlm.people.service;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.vo.ResponseVo;

public interface ChaService {
    Cha selectByChaId(Long id);
    Cha insertByCha(Cha cha);
    Cha updateByCha(Cha cha);
    boolean delecteByChaId(Long id);
}
