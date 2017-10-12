package com.qfedu.service.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.persistence.DeptDao;
import com.qfedu.persistence.impl.DeptDaoImpl;
import com.qfedu.service.DeptService;
import com.qfedu.util.HibernateUtil;

/**
 *
 * @author 羊波
 *
 */
public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public List<Dept> listAllDepts() {
		return deptDao.findAll();
	}

	@Override
	public Dept findById(int no) {
		 return deptDao.findById(no);
	}

	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.update(dept);
	}

	@Override
	public boolean removeDeptByNo(Integer no) {
		Dept dept=deptDao.findById(no);
		if (dept!=null){
			HibernateUtil.getSession().delete(dept);
			return true;
		}
		return false;
	}

	@Override
	public boolean addNewDept(Dept dept) {
		return deptDao.save(dept);
	}

	@Override
	public Dept getDeptByNo(Integer no) {
		return deptDao.findById(no);
	}

}
