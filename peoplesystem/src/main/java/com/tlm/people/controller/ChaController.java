package com.tlm.people.controller;

import com.alibaba.fastjson2.JSONArray;
import com.tlm.people.entity.Cha;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.ChaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *(Cha)控制表层
 */
@RestController
@RequestMapping("/tlm/people/cha")
public class ChaController {
    @Resource
    private ChaService chaService;

    /***
     * 通过id查询cha类
     * @param id
     * @return
     */
    @PostMapping("/selectByChaId")
    public ResponseEntity<Cha> selectByChaId(@RequestParam Long id){
        return ResponseEntity.ok(this.chaService.selectByChaId(id));
    }

    /**
     * 查看所有通道
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(){
        List<Cha> chaList = chaService.findAll();
        return JSONArray.toJSONString(new ResponseVo("查看所有数据",chaList,"0x200"));
    }

    /**
     * 添加通道
     * @param cha
     * @return
     */
    @PostMapping("/insertByCha")
    public ResponseEntity<Cha> insertByCha(@RequestBody Cha cha) {
        return ResponseEntity.ok(this.chaService.insertByCha(cha));
    }

    /**
     *修改通道内容
     * @param cha
     * @return
     */
    @PutMapping("/updateByCha")
    public ResponseEntity<Cha> updateByCha(@RequestBody Cha cha) {
        return ResponseEntity.ok(this.chaService.updateByCha(cha));
    }

    /**
     * 通过id删除通道
     * @param id
     * @return
     */
    @DeleteMapping("/deleteByChaId")
    public ResponseEntity<Boolean> deleteByChaId(@RequestParam Long id) {
        return ResponseEntity.ok(this.chaService.delecteByChaId(id));
    }
}
