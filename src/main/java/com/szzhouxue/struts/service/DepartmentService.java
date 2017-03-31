package com.szzhouxue.struts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szzhouxue.struts.dao.DepartmentDao;
import com.szzhouxue.struts.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	public DepartmentDao deptDao;

	public List<Department> getDepts() {
		return deptDao.queryAll();
	}

	public Department getById(Integer id) {
		return deptDao.findOne(id);
	}
}
