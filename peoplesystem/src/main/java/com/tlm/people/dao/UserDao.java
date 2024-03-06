package com.tlm.people.dao;

import com.tlm.people.entity.Stu;
import com.tlm.people.entity.User;
import com.tlm.people.entity.bo.UserLoginBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-04 17:48:22
 */
@Mapper
public interface UserDao {


    public void updateLoginTime(User user);


    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  查找用户名
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  注册用户
     * @param user
     * @return
     */
    public Long userReg(User user);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);


    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    long count(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    void update(User user);

    /**
     * 获取需要摇的学生
     * @return
     */
    public List<Stu> getStudents();

    /**
     * 更新学生的状态
     * @return
     */
    void updateStudents(List<Stu> stus);
}

