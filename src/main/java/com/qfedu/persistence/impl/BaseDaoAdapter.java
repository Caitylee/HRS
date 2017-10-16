package com.qfedu.persistence.impl;

import com.qfedu.persistence.BaseDao;
import com.qfedu.util.HibernateUtil;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDaoAdapter<E,K extends Serializable> implements BaseDao<E,K> {


    private Class<E> entityType;
    private String entityName;

    //子类在创建实例时会自动调用父类的无参构造
    protected BaseDaoAdapter() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityType = (Class<E>) pt.getActualTypeArguments()[0];
        entityName = entityType.getSimpleName();
    }


    @Override
    public K save(E entity) {
        return (K) HibernateUtil.getSession().save(entity);
    }

    @Override
    public boolean deleteByID(K id) {
        return HibernateUtil.getSession().createQuery("delete from " + entityName + " as o where o.id=:id ")//"delete from " + entityName + " as o where o.id=:id"
                .setParameter("id",id)
                .executeUpdate()==1;
    }

    @Override
    public E update(E entity) {
        return (E) HibernateUtil.getSession().merge(entity);
    }

    @Override
    public E findById(K id) {
        return HibernateUtil.getSession().get(entityType,id);
    }

    @Override
    public List<E> findAll() {
        return HibernateUtil.getSession().createQuery("from "+entityName).getResultList();
    }
}
