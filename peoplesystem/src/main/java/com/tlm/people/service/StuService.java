package com.tlm.people.service;

import com.tlm.people.entity.Stu;

import java.util.List;

/**
 * (Stu)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 17:47:24
 */
public interface StuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Stu queryById(Long id);


    /**
     * 新增数据
     *
     * @param stu 实例对象
     * @return 实例对象
     */
    Stu insert(Stu stu);

    /**
     * 修改数据
     *
     * @param stu 实例对象
     * @return 实例对象
     */
    Stu update(Stu stu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    //查询所有
    List<Stu> findAll();

    //修改状态
    void updateStatus(List<Long> stuIdList);

    /**
     * 删除所有数据
     */
    void deleteByAll();
}
