package com.qfedu.persistence;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.PageBean;

/**
 * Ա�����ݷ��ʶ���ӿ�
 * @author ��
 *
 */
public interface EmpDao extends BaseDao<Emp,Integer>{

	/**
	 * ���ݲ��Ų��Ҹò�������Ա��
	 * @param dept ����
	 * @param page ҳ��
	 * @param size ҳ���С
	 * @return ��ҳ������
	 */
	PageBean findEmpsByDeptNo(Dept dept, int page, int size);

}
