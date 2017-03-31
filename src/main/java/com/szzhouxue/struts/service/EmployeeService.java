package com.szzhouxue.struts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szzhouxue.struts.dao.EmployeeDao;
import com.szzhouxue.struts.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public void add(Employee emp) {
		employeeDao.save(emp);
	}

	public List<Employee> list() {
		return employeeDao.queryAll();
	}

	public Employee getEmpById(int id) {
		return employeeDao.findOne(id);
	}

	@Transactional
	public void update(Employee emp) {
		employeeDao.update(emp.getName(), emp.getAddress(), emp.getEmail(),
				emp.getDept(), emp.getId());
	}

	@Transactional
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

}
