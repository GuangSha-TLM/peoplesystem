package com.tlm.people.dao;

import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChaWithStuDao {
    List<Stu> getStudentsByChannelId(Long channelId);
    List<Long> getStudentIdsByChannelId(Long channelId);
}
