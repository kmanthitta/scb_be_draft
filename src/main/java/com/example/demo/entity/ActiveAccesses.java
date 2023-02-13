package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users_active_accesses")
public class ActiveAccesses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bank_id;
	private String role;
	private String location;
	private String group;
	private String sas_viya;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSas_viya() {
		return sas_viya;
	}
	public void setSas_viya(String sas_viya) {
		this.sas_viya = sas_viya;
	}
	
	@Override
	public String toString() {
		return "ActiveAccesses [id=" + id + ", bank_id=" + bank_id + ", role=" + role + ", location=" + location
				+ ", group=" + group + ", sas_viya=" + sas_viya + "]";
	}
	
	
}
