package com.tlm.people.controller;

import com.tlm.people.dao.ChaWithStuDao;
import com.tlm.people.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/tlm/people/chaWithStu")
public class ChaWithStuController {

    @Resource
    private ChaWithStuDao chaWithStuDao;
    @GetMapping("/{channelId}/students")
    public ResponseEntity<List<Stu>> getStudentsByChannelId(@PathVariable Long channelId) {
        List<Stu> students = chaWithStuDao.getStudentsByChannelId(channelId);
        return ResponseEntity.ok(students);
    }

}

















