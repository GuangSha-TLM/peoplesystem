package com.tlm.people.controller;

import com.tlm.people.entity.PageRequest;
import com.tlm.people.entity.Stu;
import com.tlm.people.service.StuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.Page;

import javax.annotation.Resource;

/**
 * (Stu)表控制层
 *
 * @author makejava
 * @since 2024-03-04 17:47:18
 */
@RestController
@RequestMapping("stu")
public class StuController {
    /**
     * 服务对象
     */
    @Resource
    private StuService stuService;

//    /**
//     * 分页查询
//     *
//     * @param stu 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<Stu>> queryByPage(Stu stu, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.stuService.queryByPage(stu, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Stu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.stuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param stu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Stu> add(Stu stu) {
        return ResponseEntity.ok(this.stuService.insert(stu));
    }

    /**
     * 编辑数据
     *
     * @param stu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Stu> edit(Stu stu) {
        return ResponseEntity.ok(this.stuService.update(stu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.stuService.deleteById(id));
    }

}

