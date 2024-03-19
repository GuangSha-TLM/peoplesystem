package com.tlm.people.dao;


import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChaWithStuDao {
    /**
     * 通过通道id查询名单
     * @param channelId
     * @return
     */
    List<Stu> getStudentsByChannelId(Long channelId);

    /**
     * 通过通道id查询名单id
     * @param channelId
     * @return
     */
    List<Long> getStudentIdsByChannelId(Long channelId);

    /**
     * 添加ChaWithStu关联表
     * @param chaWithStu
     * @return
     */
    void addChaWithStu(ChaWithStu chaWithStu);
}
