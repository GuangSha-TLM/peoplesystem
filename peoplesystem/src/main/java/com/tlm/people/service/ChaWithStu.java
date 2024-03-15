package com.tlm.people.service;

import com.tlm.people.entity.Stu;

import java.util.List;

public interface ChaWithStu {
    List<Stu> getStudentsByChannelId(Long channelId);
}
