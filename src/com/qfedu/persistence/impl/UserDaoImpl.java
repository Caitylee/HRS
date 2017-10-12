package com.qfedu.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.util.HibernateUtil;

/**
 * �û����ݷ��ʶ����ʵ����
 * @author ��
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public boolean save(User entity) {
		return HibernateUtil.getSession().save(entity)!=null;
	}


	@Override
	public boolean update(User entity) {
		return false;
	}

	@Override
	public User findById(String id) {
		return HibernateUtil.getSession().get(User.class,id);
	}


}
