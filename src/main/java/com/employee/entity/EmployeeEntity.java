package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	private String ename;
	private String edesignation;
	private Integer eage;
	private String email;
	private String egender;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(Integer eid, String ename, String edesignation, Integer eage, String email, String egender) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edesignation = edesignation;
		this.eage = eage;
		this.email = email;
		this.egender = egender;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEgender() {
		return egender;
	}

	public void setEgender(String egender) {
		this.egender = egender;
	}

}
