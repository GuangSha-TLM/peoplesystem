package com.tlm.people.service.impl;

import com.tlm.people.entity.Stu;
import com.tlm.people.dao.StuDao;
import com.tlm.people.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    //查询所有
    @Override
    public List<Stu> findAll() {
        List<Stu> stuList = stuDao.findAll();
        return stuList;
    }

    //修改状态
    @Override
    public void updateStatus(List<Long> stuIdList) {

        //stream流优化
        stuIdList.stream()
                .map(stuDao :: queryById)
                .peek(stu -> ((Stu) stu).setStatus(((Stu) stu).getStatus() == 0 ? 1 : 0))
                .forEach(stuDao :: updateStatus);

    }

    @Override
    public void deleteByAll() {
        stuDao.deleteByAll();
    }

}
