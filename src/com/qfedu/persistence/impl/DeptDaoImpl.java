package com.qfedu.persistence.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.util.HibernateUtil;

/**
 * 部门数据访问对象实现类
 * @author 羊波
 *
 */
public class DeptDaoImpl implements DeptDao {

	@Override
	public boolean save(Dept entity) {
		return HibernateUtil.getSession().save(entity)!=null;
	}

	@Override
	public boolean deleteByID(Integer id) {
		return HibernateUtil.getSession().createQuery("delete from Dept as d where d.no=:no")
		.setParameter("no",id)
		.executeUpdate()==1;
	}

	@Override
	public boolean update(Dept entity) {
		Dept temp=findById(entity.getNo());
		if (temp!=null){
			HibernateUtil.getSession().merge(entity);
			return true;
		}
		return false;
	}

	@Override
	public Dept findById(Integer id) {
		return HibernateUtil.getSession().get(Dept.class,id);
	}

	@Override
	public List<Dept> findAll() {
		return HibernateUtil.getSession().createQuery("from Dept").getResultList();
	}
}
