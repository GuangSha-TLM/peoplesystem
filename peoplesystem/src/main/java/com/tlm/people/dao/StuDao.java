package com.tlm.people.dao;

import com.tlm.people.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * (Stu)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-04 17:48:41
 */
@Mapper
public interface StuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Stu queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param stu 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Stu> queryAllByLimit(Stu stu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param stu 查询条件
     * @return 总行数
     */
    long count(Stu stu);

    /**
     * 新增数据
     *
     * @param stu 实例对象
     * @return 影响行数
     */
    int insert(Stu stu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Stu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Stu> entities);

    /**
     * 修改数据
     *
     * @param stu 实例对象
     * @return 影响行数
     */
    int update(Stu stu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    //查询所有
    List<Stu> findAll();

    //修改状态
    void updateStatus(Stu stu);

    /**
     * 批量删除
     * @param deleteIdList
     */
    void deleteByAll(List<Long> deleteIdList);
}

