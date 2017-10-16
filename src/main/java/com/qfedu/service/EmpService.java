package com.qfedu.service;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

/**
 * Ա�����ҵ��ӿ�
 * @author ���
 *
 */
public interface EmpService {
	
	/**
	 * �����Ա��
	 * @param emp Ա������
	 * @return ��ӳɹ�����true���򷵻�false
	 */
	Integer addNewEmp(Emp emp);

	/**
	 * ���ݲ��ű���г���������Ա��
	 * @param dept ���Ŷ���
	 * @return ����Ա��������б�����
	 */
	PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept, int page, int size);

	/**
	 * ͨ��Ա����Ų�ѯԱ��
	 * @param no Ա�����
	 * @return Ա������
	 */
	Emp findEmpByNo(Integer no);

	/**
	 * ͨ��Ա�����ɾ��Ա��
	 * @param no Ա�����
	 * @return ɾ���ɹ�����True
	 */
    boolean removeEmpByNo(int no);

    Emp updataEmp(Emp emp);
}
