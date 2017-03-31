package com.szzhouxue.struts.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.szzhouxue.struts.entity.Department;
import com.szzhouxue.struts.entity.Employee;
import com.szzhouxue.struts.service.DepartmentService;
import com.szzhouxue.struts.service.EmployeeService;

public class EmployeeAction {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService deptService;

	private Integer id;
	private Employee emp;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String list() {
		System.out.println("进入list方法");
		ActionContext actionContext = ActionContext.getContext();
		List<Employee> list = employeeService.list();
		actionContext.put("emps", list);
		return Action.SUCCESS;
	}

	public String edit() {
		System.out.println("进入edit方法");
		if (id == null) {
			return Action.ERROR;
		}
		ActionContext actionContext = ActionContext.getContext();
		Employee employee = employeeService.getEmpById(id);
		actionContext.put("emp", employee);
		List<Department> depts = deptService.getDepts();
		actionContext.put("depts", depts);
		return Action.SUCCESS;
	}

	public String update() {
		System.out.println("进入update");
		if (emp != null && emp.getDept() != null
				&& emp.getDept().getId() != null) {
			employeeService.update(emp);
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String add() {
		ActionContext actionContext = ActionContext.getContext();
		List<Department> depts = deptService.getDepts();
		actionContext.put("depts", depts);
		return Action.SUCCESS;
	}

	public String addEmp() {
		if (emp != null && emp.getDept() != null
				&& emp.getDept().getId() != null) {
			emp.setDept(deptService.getById(emp.getDept().getId()));
			employeeService.add(emp);
			return Action.SUCCESS;
		} 
		return Action.ERROR;
	}

	public String delete() {
		if (id != null) {
			employeeService.delete(id);
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
}
