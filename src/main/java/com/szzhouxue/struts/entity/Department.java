package com.szzhouxue.struts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_department")
public class Department {

	private Integer id;
	private String name;

	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
		super();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "department_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Transient
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
