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
public class UserActiveAccesses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date createdOn;
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date updatedOn;
	private String bankId;
	private String email;
	private String role;
	private String location;
	private String groupName;
	private String sasViya;
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
	public String getBankId() {
		return bankId;
	}
	public void setBank_id(String bankId) {
		this.bankId = bankId;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroup_name(String groupName) {
		this.groupName = groupName;
	}
	public String getSasViya() {
		return sasViya;
	}
	public void setSasViya(String sasViya) {
		this.sasViya = sasViya;
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
		return "ActiveAccesses [id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", bankId="
				+ bankId + ", email=" + email + ", role=" + role + ", location=" + location + ", groupName="
				+ groupName + ", sasViya=" + sasViya + ", lmEmail=" + lmEmail + ", dmEmail=" + dmEmail
				+ ", groupStatus=" + groupStatus + ", userStatus=" + userStatus + "]";
	}
	
	
}
