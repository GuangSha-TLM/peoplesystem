package com.tlm.people.entity;

import java.io.Serializable;

/**
 * 通道关联实体类
 */
public class ChaWithStu implements Serializable {
    private Long id;
    private Long channel_id;
    private Long student_id;

    public ChaWithStu() {
    }

    public ChaWithStu(Long id, Long channel_id, Long student_id) {
        this.id = id;
        this.channel_id = channel_id;
        this.student_id = student_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannel_id(Long id) {
        return channel_id;
    }

    public void setChannel_id(Long channel_id) {
        this.channel_id = channel_id;
    }

    public Long getStudent_id(Long id) {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "ChaWithStu{" +
                "id=" + id +
                ", channel_id=" + channel_id +
                ", student_id=" + student_id +
                '}';
    }
}
