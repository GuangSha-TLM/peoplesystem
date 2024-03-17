package com.tlm.people.service;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;

import java.util.List;

public interface ChaWithStuService {
    /**
     * 通过通道id查询名单
     * @param channelId
     * @return
     */
    List<Stu> getStudentsByChannelId(Long channelId);
    ChaWithStu addChaWithStu(ChaWithStu chaWithStu);

    /**
     * 关联表单
     * @param cha
     * @param stu
     */
    void addChaWithStu(Cha cha , Stu stu);
}
