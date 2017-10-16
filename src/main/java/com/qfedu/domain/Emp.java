package com.qfedu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Ա����
 * @author ��
 *
 */
@Entity
@Table(name = "tb_emp")
public class Emp implements Serializable {
	@Id
	@Column(name = "eno")
	private Integer no;				// ���
	@Column(name = "ename")
	private String name;		// ����
	@Column(name = "esex")
	private Boolean sex;			// �Ա�
	@Column(name = "ejob")
	private String job;				// ְλ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emgr")
	private Emp mgr;				// ����
	@Column(name = "esal")
	private Double salary;		// ��н
	@Column(name = "ehiredate")
	private Date hireDate;		// ��ְ����
	@Column(name = "estatus")
	private Boolean status;	// �Ƿ���ְ
	@Column(name = "ephoto")
	private String photo;		// ��Ƭ(·��)
	@Column(name = "etel")
	private String tel;				// �绰����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dno")
	private Dept dept;				// ���ڲ���

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Emp getMgr() {
		return mgr;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
