package com.tlm.people.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tlm.people.entity.PageRequest;
import com.tlm.people.entity.Stu;
import com.tlm.people.dao.StuDao;
import com.tlm.people.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Stu)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 17:47:26
 */
@Service("stuService")
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Stu queryById(Long id) {
        return this.stuDao.queryById(id);
    }

//    /**
//     * 分页查询
//     *
//     * @param stu 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<Stu> queryByPage(Stu stu, PageRequest pageRequest) {
//        long total = this.stuDao.count(stu);
//        return new PageImpl<>(this.stuDao.queryAllByLimit(stu, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param stu 实例对象
     * @return 实例对象
     */
    @Override
    public Stu insert(Stu stu) {
        this.stuDao.insert(stu);
        return stu;
    }

    /**
     * 修改数据
     *
     * @param stu 实例对象
     * @return 实例对象
     */
    @Override
    public Stu update(Stu stu) {
        this.stuDao.update(stu);
        return this.queryById(stu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.stuDao.deleteById(id) > 0;
    }
}
