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
     *  逻辑删除（0：正常，1：删除）
     */
    private Integer delFlag;
/**
     *  创建时间
     */
    private Date createtime;
/**
     *  更新时间
     */
    private Date updatetime;


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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

}

