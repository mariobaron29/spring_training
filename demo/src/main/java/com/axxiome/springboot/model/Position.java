package com.axxiome.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private int name;
	
	
	public Position() {
		super();
		
	}


	public Position(Long id, int name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getName() {
		return name;
	}


	public void setName(int name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
