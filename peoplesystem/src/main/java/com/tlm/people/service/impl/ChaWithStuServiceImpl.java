package com.tlm.people.service.impl;


import com.tlm.people.dao.ChaDao;
import com.tlm.people.dao.ChaWithStuDao;
import com.tlm.people.dao.FunctionMapper;
import com.tlm.people.dao.StuDao;
import com.tlm.people.entity.Cha;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.FunctionExcelVo;
import com.tlm.people.entity.vo.FunctionExcelVo1;
import com.tlm.people.service.ChaWithStuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ChaWithStuServiceImpl implements ChaWithStuService {
    @Resource
    private ChaWithStuDao chaWithStuDao;
    @Resource
    private ChaDao chaDao;
    @Resource
    private StuDao stuDao;
    @Resource
    private FunctionMapper functionMapper;

    /**
     * 通过通道id查询名单信息
     * @param channelId
     * @return
     */
    @Override
    public List<Stu> getStudentsByChannelId(Long channelId) {
        List<Long> studentIds = chaWithStuDao.getStudentIdsByChannelId(channelId);
        if (studentIds.isEmpty()) {
            return Collections.emptyList();
        }
        return chaWithStuDao.getStudentsByChannelId(channelId);  // 修正此处返回值
    }

    /**
     * 关联表格添加
     * @param chaWithStu
     * @return
     */
//    @Override
//    public ChaWithStu addChaWithStu(ChaWithStu chaWithStu) {
//        List<FunctionExcelVo1> functionExcelVoList1 = new ArrayList<>();
//        FunctionExcelVo1 functionExcelVo1 = new FunctionExcelVo1();
//        // 将 functionExcelVo 添加到列表中
//        functionExcelVoList1.add(functionExcelVo1);
//        // 保存数据
//        functionMapper.saveData1(functionExcelVoList1);
//        // 获取学生ID
//        long studentId = functionExcelVo1.getId();
//        // 设置学生ID
//        chaWithStu.setStudentId(studentId);
//        // 添加ChaWithStu
//        this.chaWithStuDao.addChaWithStu(chaWithStu);
//        return chaWithStu;
//    }


    /**
     * 关联表格添加
     *
     * @param cha
     * @param stu
     */
    @Transactional
    public void addChaWithStu(Cha cha, Stu stu) {
        // 添加Cha和Stu的Id数据
        chaDao.insertByCha(cha);
        stuDao.insert(stu);
        // 获取Cha和Stu添加后的id值
        Long chaId = cha.getId();
        Long stuId = stu.getId();
        // 根据Cha和Stu的id值添加到表3中
        ChaWithStu chaWithStu = new ChaWithStu();
        chaWithStu.setChannelId(chaId);
        chaWithStu.setStudentId(stuId);
        chaWithStuDao.addChaWithStu(chaWithStu);

    }

}
