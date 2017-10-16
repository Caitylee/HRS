package com.qfedu.service.impl;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.persistence.EmpDao;
import com.qfedu.persistence.impl.EmpDaoImpl;
import com.qfedu.service.EmpService;
import com.qfedu.util.PageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工相关业务实现类
 * @author 羊波
 *
 *
 */
public class EmpServiceImpl implements EmpService {
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public Integer addNewEmp(Emp emp) {
		return empDao.save(emp);
	}
	
	@Override
	public PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept, int page, int size) {
		PageBean<Emp> pageBean=empDao.findEmpsByDeptNo(dept,page,size);
		List<Emp> empList=pageBean.getDataModel();
		List<EmpDto> empDtoList=new ArrayList<>();
		for (Emp emp : empList) {
			empDtoList.add(new EmpDto(emp));
		}
		return new PageBean<>(empDtoList,pageBean.getTotalPage(),page,size);

	}

	@Override
	public Emp findEmpByNo(Integer no) {
		return  empDao.findById(no);
	}

	@Override
	public boolean removeEmpByNo(int no) {
		return empDao.deleteByID(no);

	}

	@Override
	public Emp updataEmp(Emp emp) {
		return empDao.update(emp);
	}

}
