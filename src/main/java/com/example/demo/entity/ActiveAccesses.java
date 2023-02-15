package com.example.demo.entity;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="users_active_accesses")
public class ActiveAccesses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date created_on;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date updated_on;
	private String bank_id;
	private String email;
	private String role;
	private String location;
	private String group_name;
	private String sas_viya;
	private String lm_email;
	private String dm_email;
	private String group_status;
	private String user_status;
	
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
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getSas_viya() {
		return sas_viya;
	}
	public void setSas_viya(String sas_viya) {
		this.sas_viya = sas_viya;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLm_email() {
		return lm_email;
	}
	public void setLm_email(String lm_email) {
		this.lm_email = lm_email;
	}
	public String getDm_email() {
		return dm_email;
	}
	public void setDm_email(String dm_email) {
		this.dm_email = dm_email;
	}
	public String getGroup_status() {
		return group_status;
	}
	public void setGroup_status(String group_status) {
		this.group_status = group_status;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	@Override
	public String toString() {
		return "ActiveAccesses [id=" + id + ", created_on=" + created_on + ", updated_on=" + updated_on + ", bank_id="
				+ bank_id + ", email=" + email + ", role=" + role + ", location=" + location + ", group_name="
				+ group_name + ", sas_viya=" + sas_viya + ", lm_email=" + lm_email + ", dm_email=" + dm_email
				+ ", group_status=" + group_status + ", user_status=" + user_status + "]";
	}
	
	
}
