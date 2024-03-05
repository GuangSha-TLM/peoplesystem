package com.tlm.people.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-03-04 17:48:25
 */
public class User implements Serializable {
    private static final long serialVersionUID = -16000919610921848L;

    private Long id;
/**
     *  用户名
     */
    private String username;
/**
     * 密码
     */
    private String password;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     *  更新人
     */
    private Integer updateBy;

    /**
     *  更新时间
     */
    private Date updateTime;

    /**
     *  逻辑删除（0：正常，1：删除）
     */
    private Integer delFlag;

    public User() {
    }

    public User(Long id, String username, String password, Integer createBy, Date createTime, Integer updateBy, Date updateTime, Integer delFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                '}';
    }
}

