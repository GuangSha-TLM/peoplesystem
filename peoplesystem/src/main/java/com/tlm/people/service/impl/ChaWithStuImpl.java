package com.tlm.people.service.impl;


import com.tlm.people.dao.ChaWithStuDao;
import com.tlm.people.entity.Stu;
import com.tlm.people.service.ChaWithStu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class ChaWithStuImpl implements ChaWithStu {
    @Resource
    private ChaWithStuDao chaWithStuDao;


    public List<Stu> getStudentsByChannelId(Long channelId) {
        List<Long> studentIds = chaWithStuDao.getStudentIdsByChannelId(channelId);
        if (studentIds.isEmpty()) {
            return Collections.emptyList();
        }
        return chaWithStuDao.getStudentsByChannelId(channelId);
    }

}
