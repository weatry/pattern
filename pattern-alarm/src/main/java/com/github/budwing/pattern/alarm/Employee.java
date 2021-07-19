package com.github.budwing.pattern.alarm;

public class Employee {
	private int id;
	private String name;
	private String mobile;
	private String telephone;
	private String email;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String mobile, String telephone,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.telephone = telephone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
