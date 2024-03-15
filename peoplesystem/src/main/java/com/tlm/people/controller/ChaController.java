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

@RestController
@RequestMapping("/tlm/people/cha")
public class ChaController {
    @Resource
    private ChaService chaService;

    @PostMapping("/selectByChaId")
    public ResponseEntity<Cha> selectByChaId(@RequestParam Long id){
        return ResponseEntity.ok(this.chaService.selectByChaId(id));
    }

    @GetMapping("/findAll")
    public String findAll(){
        List<Cha> chaList = chaService.findAll();
        return JSONArray.toJSONString(new ResponseVo("查看所有数据",chaList,"0x200"));
    }

    @PostMapping("/insertByCha")
    public ResponseEntity<Cha> insertByCha(@RequestBody Cha cha) {
        return ResponseEntity.ok(this.chaService.insertByCha(cha));
    }

    @PutMapping("/updateByCha")
    public ResponseEntity<Cha> updateByCha(@RequestBody Cha cha) {
        return ResponseEntity.ok(this.chaService.updateByCha(cha));
    }

    @DeleteMapping("/deleteByChaId")
    public ResponseEntity<Boolean> deleteByChaId(@RequestParam Long id) {
        return ResponseEntity.ok(this.chaService.delecteByChaId(id));
    }
}
