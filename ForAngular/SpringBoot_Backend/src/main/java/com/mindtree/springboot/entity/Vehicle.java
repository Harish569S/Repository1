package com.mindtree.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String registerNo;
	private String name;
	private String type;
	private String state;
	private String city;
	
	
	public Vehicle() {
		super();
	}


	public Vehicle(String registerNo, String name, String type, String state, String city) {
		super();
		this.registerNo = registerNo;
		this.name = name;
		this.type = type;
		this.state = state;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRegisterNo() {
		return registerNo;
	}


	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registerNo=" + registerNo + ", name=" + name + ", type=" + type + ", state="
				+ state + ", city=" + city + "]";
	}
	
	
	
	

}
