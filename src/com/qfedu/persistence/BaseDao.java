package com.qfedu.persistence;

import com.qfedu.domain.Dept;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的实体访问接口
 * @param <E> 实体类型
 * @param <K> 标识
 */

public interface BaseDao<E,K extends Serializable> {//extends:泛型限定
    /**
     * 保存实体
     * @param entity 实体对象
     * @return 保存成功返回true否则返回false
     */
    default boolean save(E entity){return false;}

    /**
     * 删除实体
     * @param id 实体主键
     * @return 删除成功返回true否则返回false
     */
    default boolean deleteByID(K id){return false;}

    /**
     * 更新实体
     * @param entity 实体对象
     * @return 更新成功返回true否则返回false
     */
    default boolean update(E entity){return false;}

    /**
     * 根据实体主键查询实体
     * @param id 实体主键
     * @return 部门对象或null
     */
    default E findById(K id){return null;}

    /**
     * 查询所有实体
     * @return 保存实体对象的列表容器
     */
    default List<E> findAll(){return null;}

   /* *//**
     * 查询实体数量
     * @param id 实体编号
     * @return 部门人数
     *//*
    int countEntityByNo(K id);*/
}
