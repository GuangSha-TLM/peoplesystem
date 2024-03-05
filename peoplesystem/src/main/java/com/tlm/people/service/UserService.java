package com.tlm.people.service;

import com.tlm.people.entity.User;
import com.tlm.people.entity.bo.UserLoginBo;
import com.tlm.people.entity.vo.ResponseVo;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 17:48:25
 */
public interface UserService {

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    ResponseVo userLogin(UserLoginBo userLoginBo);

    /**
     * @param userLoginBo
     * @return ResponseVo.class
     * @Auther Oh… Yeah!!! 2024-3-5
     * 用户注册
     */
    ResponseVo userReg(UserLoginBo userLoginBo);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *      摇人
     * @return ResponseVo.class
     */
    ResponseVo userShake(Integer number);
}
