package com.tlm.people.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Stu)实体类
 *
 * @author makejava
 * @since 2024-03-04 17:47:20
 */
public class Stu implements Serializable {
    private static final long serialVersionUID = -68241178059458164L;

    private Long id;
/**
     *  学号/工号
     */
    private Long stuId;
/**
     * 状态（0：未选， 1：被选）
     */
    private Integer status;
/**
     *  创建时间
     */
    private Date createtime;
/**
     *  修改时间
     */
    private Date updatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

