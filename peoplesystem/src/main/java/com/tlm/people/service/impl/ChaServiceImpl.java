package com.tlm.people.service.impl;

import com.tlm.people.dao.ChaDao;
import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.service.ChaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ChaServiceImpl implements ChaService {
    @Resource
    private ChaDao chaDao;
    @Override
    public Cha selectByChaId(Long id) {
        return this.chaDao.selectByChaId(id);
    }

    @Override
    public List<Cha> findAll() {
        List<Cha> chaList = chaDao.findAll();
        return chaList;
    }

    @Override
    public Cha insertByCha(Cha cha) {
        cha.setCreateTime(new Date());
        this.chaDao.insertByCha(cha);
        return cha;
    }

    @Override
    public Cha updateByCha(Cha cha) {
        this.chaDao.updateByCha(cha);
        return this.selectByChaId(cha.getId());
    }

    @Override
    public boolean delecteByChaId(Long id) {
        return this.chaDao.deleteByChaId(id) > 0;
    }

}
