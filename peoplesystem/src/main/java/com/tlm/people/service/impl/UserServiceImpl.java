package com.tlm.people.service.impl;

import com.tlm.people.dao.UserDao;
import com.tlm.people.entity.Stu;
import com.tlm.people.entity.User;
import com.tlm.people.entity.bo.UserLoginBo;
import com.tlm.people.entity.vo.ResponseVo;
import com.tlm.people.service.UserService;
import com.tlm.people.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 17:48:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private FunctionServiceImpl functionService;

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *      摇人
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userShake(Integer number) {

        //functionService.importData();

        List<Stu> students =  userDao.getStudents();

        Collections.shuffle(students);
//        System.out.println(students);
//        System.out.println(students.subList(0, number));
        List<Stu> stus = students.subList(0, number);

        for (int i = 0; i < stus.size(); i++) {
            stus.get(i).setStatus(1);
        }

        userDao.updateStudents(stus);

        return new ResponseVo("一支穿云箭",stus,"0x200");
    }

    /**
     * @param userLoginBo
     * @return ResponseVo.class
     * @Auther Oh… Yeah!!! 2024-3-5
     * 用户注册
     */
    public ResponseVo userReg(UserLoginBo userLoginBo){
        User user = userDao.findByUsername(userLoginBo.getUsername());

        if(user != null){
            return new ResponseVo("该用户名已存在",null,"0x202");
        }

        Long aLong = userDao.userReg(new User(
                userLoginBo.getUsername(),
                userLoginBo.getPassword(),
                userLoginBo.getUsername(),
                new Date(),
                userLoginBo.getUsername(),
                new Date(),
                0
        ));

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
        user.setUpdateTime(new Date());
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
