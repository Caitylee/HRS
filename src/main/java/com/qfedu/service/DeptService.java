package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Dept;

/**
 * �������ҵ��ӿ�
 * @author ��
 *
 */
public interface DeptService {
	
	/**
	 * ����²���
	 * @param dept ���Ŷ���
	 * @return ��ӳɹ�����true���򷵻�false
	 */
	Integer addNewDept(Dept dept);
	
	/**
	 * ɾ������
	 * @param no ���ű��
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	boolean removeDeptByNo(Integer no);
	
	/**
	 * ���ݲ��Ż�ȡ������Ϣ
	 */
	Dept getDeptByNo(Integer no);

	/**
	 * �г����в���
	 * @return ���沿�Ŷ�����б�����
	 */
	List<Dept> listAllDepts();

	/**
	 * ���ݲ��ű�Ų�ѯ����
	 * @param no ����ID
	 * @return
	 */
	Dept findById(int no);

	/**
	 * ���²�����Ϣ
	 * @param dept
	 * @return
	 */
    Dept updateDept(Dept dept);
}
