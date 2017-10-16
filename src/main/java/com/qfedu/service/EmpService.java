package com.qfedu.service;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

/**
 * 员工相关业务接口
 * @author 骆昊
 *
 */
public interface EmpService {
	
	/**
	 * 添加新员工
	 * @param emp 员工对象
	 * @return 添加成功返回true否则返回false
	 */
	Integer addNewEmp(Emp emp);

	/**
	 * 根据部门编号列出部门所有员工
	 * @param dept 部门对象
	 * @return 保存员工对象的列表容器
	 */
	PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept, int page, int size);

	/**
	 * 通过员工编号查询员工
	 * @param no 员工编号
	 * @return 员工对象
	 */
	Emp findEmpByNo(Integer no);

	/**
	 * 通过员工编号删除员工
	 * @param no 员工编号
	 * @return 删除成功返回True
	 */
    boolean removeEmpByNo(int no);

    Emp updataEmp(Emp emp);
}
