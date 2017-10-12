package com.qfedu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static final SessionFactory FACTORY;

    private HibernateUtil() {
        throw new AssertionError();
    }

    static {
        FACTORY = new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession(){
        return FACTORY.getCurrentSession();
    }
}
