package com.qfedu.persistence.impl;

import java.util.List;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.dto.EmpDto;
import com.qfedu.persistence.EmpDao;
import com.qfedu.util.*;

/**
 * 员工数据访问对象实现类
 */

public class EmpDaoImpl implements EmpDao {
    //查询员工详细信息SQL语句
    private static final String SELECT_EMP_SQL = "select eno,ename,esex,ejob,emgr,esal,ehiredate,estatus,ephoto,etel,dno from tb_emp where eno=?";
    //查询部门员工SQL语句
    private static final String SELECT_EMP_BY_DEPT_SQL =
            "select eno, ename, esex, ejob, estatus, etel from tb_emp where dno=? limit ?,?";
    //查询员工数量SQL语句
    private static final String SELECT_EMP_COUNT_SQL =
            "select count(eno) from tb_emp where dno=?";
    //添加新员工SQL语句
    private static final String INSERT_EMP_SQL =
            "insert into tb_emp values (?,?,?,?,?,?,?,?,?,?,?)";
    //删除员工SQL语句
    private static final String DEL_EMP_SQL = "delete from tb_emp where eno=?";
    //更新员工SQL语句
    private static final String UPDATA_EMP_SQL = "update tb_emp set ename=?,esex=?,ejob=?,emgr=?,esal=?,ehiredate=?,estatus=?,ephoto=?,etel=?,dno=? where eno=?";

    @Override
    public PageBean<Emp> findEmpsByDeptNo(Dept dept, int page, int size) {
        List<Emp> empList=HibernateUtil.getSession().createQuery("from Emp as e where e.dept=:dept",Emp.class)
                .setParameter("dept", dept)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
        int empCount = HibernateUtil.getSession().createQuery("select count(e) from Emp as e where e.dept=:dept",Long.class)
                .setParameter("dept",dept)
                .getSingleResult().intValue();
        int totalPage=(empCount-1)/size+1;
        return  new PageBean<>(empList,totalPage,page,size);
    }

    @Override
    public boolean save(Emp entity) {
         HibernateUtil.getSession().persist(entity);
         return true;
    }

    @Override
    public boolean deleteByID(Integer id) {
        Emp temp=findById(id);
        if (temp!=null){
            HibernateUtil.getSession().delete(temp);
            return true;
        }
        return  false;
    }

    @Override
    public boolean update(Emp entity) {
        HibernateUtil.getSession().merge(entity);
        return true;
    }

    @Override
    public Emp findById(Integer id) {
        return HibernateUtil.getSession().get(Emp.class,id);
    }

    @Override
    public List<Emp> findAll() {
        return HibernateUtil.getSession().createQuery("from Emp",Emp.class).getResultList();
    }
}
