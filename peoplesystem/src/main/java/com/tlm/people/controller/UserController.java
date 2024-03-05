package com.tlm.people.controller;

import com.alibaba.fastjson2.JSONArray;
import com.tlm.people.entity.User;
import com.tlm.people.entity.bo.UserLoginBo;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.UserService;
import com.tlm.people.service.impl.FunctionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-03-04 17:48:22
 */
@RestController
@RequestMapping("/tlm/people/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *      摇人
     * @return String.class
     */
    @PostMapping("/userShake")
    @ApiOperation("用户摇人")
    public String userShakePerson(@RequestParam("number") Integer number){

        return JSONArray.toJSONString(userService.userShake(number));
    }



    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户注册
     * @param userLoginBo
     * @return String.class
     */
    @PostMapping("/userReg")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo != null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userReg(userLoginBo));
    }


    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo == null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

