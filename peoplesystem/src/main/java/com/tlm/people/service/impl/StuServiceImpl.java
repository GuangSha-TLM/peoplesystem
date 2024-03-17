package com.tlm.people.service.impl;

import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.dao.StuDao;
import com.tlm.people.service.StuService;
import com.tlm.people.websocket.ProgressWebSocket;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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
//        stuIdList.stream()
//                .map(stuDao :: queryById)
//                .peek(stu -> stu.setStatus(stu.getStatus() == 0 ? 1 : 0))
//                .forEach(stuDao :: updateStatus);

        //开两个线程对象
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 更新学生状态线程
        executorService.submit(() -> {

            int totalStudents = stuIdList.size();
            AtomicInteger completedCount = new AtomicInteger(0);

            stuIdList.forEach(studentId -> {
                Stu student = stuDao.queryById(studentId); // 假设 stuDao 已经正确初始化
                if (student != null) {
                    student.setStatus(student.getStatus() == 0 ? 1 : 0);
                    stuDao.updateStatus(student);
                    completedCount.incrementAndGet();
                }

                // 计算进度并返回给前端
                // 通过WebSocket将进度信息返回给前端
                double progress = (double) completedCount.get() / totalStudents * 100;
                ProgressWebSocket.sendProgressUpdate(progress);
                System.out.println("Progress: " + progress + "%");

            });
        });

        // 实时查询学生状态线程
        executorService.submit(() -> {
            try {
                while (true) {
                    stuIdList.forEach(studentId -> {
                        Stu student = stuDao.queryById(studentId); // 假设 stuDao 已经正确初始化
//                        if (student != null) {
//                            System.out.println("Student " + studentId + " status: " + student.getStatus());
//                        }
                    });
                    Thread.sleep(3000); // 每3秒查询一次状态
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //关闭websocket
        ProgressWebSocket.closeAllSessions();
        // 关闭线程池
        executorService.shutdown();
    }

    /**
     * 批量删除
     * @param deleteIdList
     */
    @Override
    public void deleteByAll(List<Long> deleteIdList) {
        stuDao.deleteByAll(deleteIdList);
    }

}
