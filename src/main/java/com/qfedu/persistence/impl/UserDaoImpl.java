package com.qfedu.persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.domain.User;
import com.qfedu.persistence.UserDao;
import com.qfedu.util.HibernateUtil;

/**
 * 用户数据访问对象的实现类
 * @author 羊波
 *
 */
public class UserDaoImpl extends  BaseDaoAdapter<User,String> implements UserDao  {


}
