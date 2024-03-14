package com.tlm.people.controller;

import com.tlm.people.entity.Cha;
import com.tlm.people.service.ChaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tlm/people/cha")
public class ChaController {
    @Resource
    private ChaService chaService;

    @GetMapping("/selectByChaId/{id}")
    public ResponseEntity<Cha> selectByChaId(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.chaService.selectByChaId(id));
    }

    @PostMapping("/insertByCha")
    public ResponseEntity<Cha> insertByCha(Cha cha) {
        return ResponseEntity.ok(this.chaService.insertByCha(cha));
    }

    @PutMapping("/updateByCha")
    public ResponseEntity<Cha> updateByCha(Cha cha) {
        return ResponseEntity.ok(this.chaService.updateByCha(cha));
    }

    @DeleteMapping("/deleteByChaId")
    public ResponseEntity<Boolean> deleteByChaId(Long id) {
        return ResponseEntity.ok(this.chaService.delecteByChaId(id));
    }
}
