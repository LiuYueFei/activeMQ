package com.szzhouxue.struts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_employee")
public class Employee {

	private Integer id;

	private String name;
	private String address;
	private String email;
	private Department dept;

	public Employee(Integer id, String name, String address, String email,
			Department dept) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.dept = dept;
	}

	public Employee() {
		super();
	}

	@JoinColumn(name = "department_id")
	@ManyToOne(targetEntity = Department.class, cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "user_address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "user_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	@Transient
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", dept=" + dept + "]";
	}

}
