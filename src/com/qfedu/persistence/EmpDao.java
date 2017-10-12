package com.qfedu.persistence;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;

/**
 * 员工数据访问对象接口
 * @author 羊波
 *
 */
public interface EmpDao extends BaseDao<Emp,Integer>{

	/**
	 * 根据部门查找该部门所有员工
	 * @param dept 部门
	 * @param page 页码
	 * @param size 页面大小
	 * @return 分页器对象
	 */
	PageBean findEmpsByDeptNo(Dept dept, int page, int size);

}
