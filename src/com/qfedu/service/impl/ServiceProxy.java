package com.qfedu.service.impl;

import com.qfedu.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 业务代理类
 */
public class ServiceProxy implements InvocationHandler {
    private Object target;//被代理的业务对象

    public ServiceProxy(Object target) {
        this.target = target;
    }

    public static <T> T creatProxy(Object target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ServiceProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Object object = method.invoke(target, args);
            session.getTransaction().commit();
            return object;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

}