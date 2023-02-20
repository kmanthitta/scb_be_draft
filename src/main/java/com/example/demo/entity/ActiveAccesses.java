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
	private Date createdOn;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date updatedOn;
	private String bank_id;
	private String email;
	private String role;
	private String location;
	private String group_name;
	private String sas_viya;
	private String lmEmail;
	private String dmEmail;
	private String groupStatus;
	private String userStatus;
	
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLmEmail() {
		return lmEmail;
	}
	public void setLmEmail(String lmEmail) {
		this.lmEmail = lmEmail;
	}
	public String getDmEmail() {
		return dmEmail;
	}
	public void setDmEmail(String dmEmail) {
		this.dmEmail = dmEmail;
	}
	public String getGroupStatus() {
		return groupStatus;
	}
	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	@Override
	public String toString() {
		return "ActiveAccesses [id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", bank_id="
				+ bank_id + ", email=" + email + ", role=" + role + ", location=" + location + ", group_name="
				+ group_name + ", sas_viya=" + sas_viya + ", lmEmail=" + lmEmail + ", dmEmail=" + dmEmail
				+ ", groupStatus=" + groupStatus + ", userStatus=" + userStatus + "]";
	}
	
	
}
