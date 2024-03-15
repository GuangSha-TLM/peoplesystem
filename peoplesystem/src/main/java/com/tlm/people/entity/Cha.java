package com.tlm.people.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 2024-03-14 zhuxinyu
 *  通道实体类
 */
public class Cha implements Serializable {
    private Long id;
    private String channelName;
    private Long createBy;
    @JsonFormat(pattern = "yyyy-MM-HH",timezone = "GMT+8")
    private Date createTime;

    public Cha() {
    }

    public Cha(Long id, String channelName, Long createBy, Date createTime) {
        this.id = id;
        this.channelName = channelName;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Cha{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }
}
