package com.tlm.people.controller;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.tlm.people.entity.Stu;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.result.Result;
import com.tlm.people.service.StuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stu)表控制层
 *
 * @author makejava
 * @since 2024-03-04 17:47:18
 */
@RestController
@RequestMapping("/tlm/people/stu")
public class StuController {
    /**
     * 服务对象
     */
    @Resource
    private StuService stuService;

    //查询所有
    @GetMapping("/findAll")
    public String findAll() {
        List<Stu> stuList = stuService.findAll();
        return JSONArray.toJSONString(new ResponseVo("查看所有数据",stuList,"0x200"));
    }

    //修改状态
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestBody List<Long> stuIdList) {
        stuService.updateStatus(stuIdList);
        return JSONArray.toJSONString(new ResponseVo("修改成功",null,"0x200"));
    }

    /**
     * 批量删除
     * @param deleteIdList
     * @return
     */
    @PostMapping("/deleteByAll")
    public String deleteByAll(@RequestParam List<Long> deleteIdList){
        stuService.deleteByAll(deleteIdList);
        return JSONArray.toJSONString(new ResponseVo("已全部删除",null,"0x200"));
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectById/{id}")
    public ResponseEntity<Stu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.stuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stu 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Stu> add(Stu stu) {
        return ResponseEntity.ok(this.stuService.insert(stu));
    }

    /**
     * 编辑数据
     *
     * @param stu 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<Stu> edit(Stu stu) {
        return ResponseEntity.ok(this.stuService.update(stu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.stuService.deleteById(id));
    }


}

