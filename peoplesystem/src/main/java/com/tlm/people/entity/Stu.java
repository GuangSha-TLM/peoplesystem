package com.tlm.people.entity;

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
     * 学生姓名
     */
    private String stuName;

    /**
     * 状态（0：未选， 1：被选）
     */
    private Integer status;

    public Stu() {
    }

    public Stu(Long id, Long stuId, String stuName, Integer status) {
        this.id = id;
        this.stuId = stuId;
        this.stuName = stuName;
        this.status = status;
    }

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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", status=" + status +
                '}';
    }
}

