package com.tlm.people.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tlm.people.entity.User;
import com.tlm.people.dao.UserDao;
import com.tlm.people.entity.bo.UserLoginBo;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.UserService;
import com.tlm.people.utils.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 17:48:25
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户注册
     * @param user
     * @return ResponseVo.class
     */
    public ResponseVo userReg(User user){
        User username = userDao.findByUsername(user.getUsername());

        if(username != null){
            return new ResponseVo("该用户名已存在",null,"0x202");
        }

        Long aLong = userDao.userReg(user);

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username去获取用户
        User user = userDao.findByUsername(userLoginBo.getUsername());

        //比较用户密码和数据库中密码是否一致
        if(user == null || !user.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("登录失败",null,"0x500");
        }

        String jwt = JwtUtil.createJWT(user);


        //修改当前的登录时间
        user.setUpdatetime(new Date());
        userDao.updateLoginTime(user);

        return new ResponseVo("登录成功",jwt,"0x200");
    }



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }
}
