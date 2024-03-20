package com.tlm.people.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.tlm.people.dao.ChaWithStuDao;
import com.tlm.people.entity.ChaWithStu;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.ChaWithStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ChaWithStu)表控制层
 */
@RestController
@RequestMapping("/tlm/people/chaWithStu")
public class ChaWithStuController {

    @Resource
    private ChaWithStuDao chaWithStuDao;


    /**
     * 通过id查询通道从而查询名单
     * @param channelId
     * @return
     */
    @GetMapping("/{channelId}/students")
    public String getStudentsByChannelId(@PathVariable Long channelId) {
        List<Stu> students = chaWithStuDao.getStudentsByChannelId(channelId);
        return JSONArray.toJSONString(new ResponseVo("下载成功",students,"0x200"));
    }

//    /**
//     * 添加通道id给到关联表的channel_id中
//     * @param chaWithStu
//     * @return
//     */
//    @PostMapping("/addChaWithStu")
//    public ResponseEntity<ChaWithStu> addChaWithStu(@RequestBody ChaWithStu chaWithStu) {
//        return ResponseEntity.ok(this.chaWithStuService.addChaWithStu(chaWithStu));
//    }

}

















