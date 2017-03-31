package com.szzhouxue.struts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.szzhouxue.struts.entity.Department;
import com.szzhouxue.struts.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	@Query("select c from Employee c")
	public List<Employee> queryAll();

	@Query("update Employee emp set emp.name=?1 , emp.address=?2 , emp.email=?3 , emp.dept=?4 where emp.id=?5")
	@Modifying
	public void update(String name, String address, String email,
			Department dept, Integer id);

}
