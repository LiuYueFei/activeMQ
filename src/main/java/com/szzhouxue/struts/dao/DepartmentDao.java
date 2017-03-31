package com.szzhouxue.struts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.szzhouxue.struts.entity.Department;
import com.szzhouxue.struts.entity.Employee;

public interface DepartmentDao extends CrudRepository<Department, Integer> {

	@Query("select d from Department d")
	public List<Department> queryAll();

	

}
