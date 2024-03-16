package com.tlm.people.service;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;

import java.util.List;

public interface ChaWithStuService {
    List<Stu> getStudentsByChannelId(Long channelId);
//    ChaWithStu addChaWithStu(ChaWithStu chaWithStu);
    void addChaWithStu(Cha cha , Stu stu);
}
