package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer row_id;
	private String bank_id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date request_date;
	private Integer request_id;
	private Integer request_item_id;
	private String request_type;
	private String request_action;
	private String request_value;
	private String line_manager_email;
	private String line_manager_approval_status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date line_manager_approved_date;
	private String line_manager_comments;
	private String domain_manager_email;
	private String domain_manager_approval_status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date domain_manager_approved_date;
	private String domain_manager_comments;
	private String admin_email;
	private String admin_approval_status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date admin_approved_date;
	private String admin_comments;
	private String request_status;
	private String final_comments;
	public Integer getRow_id() {
		return row_id;
	}
	public void setRow_id(Integer row_id) {
		this.row_id = row_id;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date date) {
		this.request_date = date;
	}
	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}
	public Integer getRequest_item_id() {
		return request_item_id;
	}
	public void setRequest_item_id(Integer request_item_id) {
		this.request_item_id = request_item_id;
	}
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public String getRequest_action() {
		return request_action;
	}
	public void setRequest_action(String request_action) {
		this.request_action = request_action;
	}
	public String getRequest_value() {
		return request_value;
	}
	public void setRequest_value(String request_value) {
		this.request_value = request_value;
	}
	public String getLine_manager_email() {
		return line_manager_email;
	}
	public void setLine_manager_email(String line_manager_email) {
		this.line_manager_email = line_manager_email;
	}
	public String getLine_manager_approval_status() {
		return line_manager_approval_status;
	}
	public void setLine_manager_approval_status(String line_manager_approval_status) {
		this.line_manager_approval_status = line_manager_approval_status;
	}
	public Date getLine_manager_approved_date() {
		return line_manager_approved_date;
	}
	public void setLine_manager_approved_date(Date line_manager_approved_date) {
		this.line_manager_approved_date = line_manager_approved_date;
	}
	public String getLine_manager_comments() {
		return line_manager_comments;
	}
	public void setLine_manager_comments(String line_manager_comments) {
		this.line_manager_comments = line_manager_comments;
	}
	public String getDomain_manager_email() {
		return domain_manager_email;
	}
	public void setDomain_manager_email(String domain_manager_email) {
		this.domain_manager_email = domain_manager_email;
	}
	public String getDomain_manager_approval_status() {
		return domain_manager_approval_status;
	}
	public void setDomain_manager_approval_status(String domain_manager_approval_status) {
		this.domain_manager_approval_status = domain_manager_approval_status;
	}
	public Date getDomain_manager_approved_date() {
		return domain_manager_approved_date;
	}
	public void setDomain_manager_approved_date(Date domain_manager_approved_date) {
		this.domain_manager_approved_date = domain_manager_approved_date;
	}
	public String getDomain_manager_comments() {
		return domain_manager_comments;
	}
	public void setDomain_manager_comments(String domain_manager_comments) {
		this.domain_manager_comments = domain_manager_comments;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_approval_status() {
		return admin_approval_status;
	}
	public void setAdmin_approval_status(String admin_approval_status) {
		this.admin_approval_status = admin_approval_status;
	}
	public Date getAdmin_approved_date() {
		return admin_approved_date;
	}
	public void setAdmin_approved_date(Date admin_approved_date) {
		this.admin_approved_date = admin_approved_date;
	}
	public String getAdmin_comments() {
		return admin_comments;
	}
	public void setAdmin_comments(String admin_comments) {
		this.admin_comments = admin_comments;
	}
	public String getRequest_status() {
		return request_status;
	}
	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}
	public String getFinal_comments() {
		return final_comments;
	}
	public void setFinal_comments(String final_comments) {
		this.final_comments = final_comments;
	}
	@Override
	public String toString() {
		return "Requests [row_id=" + row_id + ", bank_id=" + bank_id + ", request_date=" + request_date
				+ ", request_id=" + request_id + ", request_item_id=" + request_item_id + ", request_type="
				+ request_type + ", request_action=" + request_action + ", request_value=" + request_value
				+ ", line_manager_email=" + line_manager_email + ", line_manager_approval_status="
				+ line_manager_approval_status + ", line_manager_approved_date=" + line_manager_approved_date
				+ ", line_manager_comments=" + line_manager_comments + ", domain_manager_email=" + domain_manager_email
				+ ", domain_manager_approval_status=" + domain_manager_approval_status
				+ ", domain_manager_approved_date=" + domain_manager_approved_date + ", domain_manager_comments="
				+ domain_manager_comments + ", admin_email=" + admin_email + ", admin_approval_status="
				+ admin_approval_status + ", admin_approved_date=" + admin_approved_date + ", admin_comments="
				+ admin_comments + ", request_status=" + request_status + ", final_comments=" + final_comments + "]";
	}
	
	
	
}
