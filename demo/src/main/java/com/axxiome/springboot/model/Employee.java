package com.axxiome.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "salary")
	private int salary;
	@Column(name = "name")
	private String name;
	@Column(name = "position")
	private String position;
	
	
	
	public Employee() {
		super();
	}


	public Employee(Long id, int salary, String name, String position) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.position = position;
	}
	
	
	public Employee(int salary, String name, String position) {
		super();
		this.salary = salary;
		this.name = name;
		this.position = position;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", position=" + position + "]";
	}
	
	
	
}
