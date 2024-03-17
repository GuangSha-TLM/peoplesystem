package com.tlm.people.entity;

import java.io.Serializable;

/**
 * 通道关联实体类
 */
public class ChaWithStu implements Serializable {
    private Long id;
    private Long channelId;//通道id
    private Long studentId;//名单id

    public ChaWithStu(Long id, Long channelId, Long studentId) {
        this.id = id;
        this.channelId = channelId;
        this.studentId = studentId;
    }
    public ChaWithStu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "ChaWithStu{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", studentId=" + studentId +
                '}';
    }
}
