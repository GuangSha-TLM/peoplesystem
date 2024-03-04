package com.tlm.people.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tlm.people.entity.PageRequest;
import com.tlm.people.entity.Stu;

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

//    /**
//     * 分页查询
//     *
//     * @param stu 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    Page<Stu> queryByPage(Stu stu, PageRequest pageRequest);

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

}
