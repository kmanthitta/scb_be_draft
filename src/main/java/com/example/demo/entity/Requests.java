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
	private String name;
	@Temporal(TemporalType.DATE)
	private Date request_date;
	private Integer request_id;
	private Integer request_item_id;
	private String request_type;
	private String request_action;
	private String request_value;
	private String line_manager_email;
	private String line_manager_approval_status;
	@Temporal(TemporalType.DATE)
	private Date line_manager_approved_date;
	private String line_manager_comments;
	private String domain_manager_email;
	private String domain_manager_approval_status;
	@Temporal(TemporalType.DATE)
	private Date domain_manager_approved_date;
	private String domain_manager_comments;
	private String sas_admin_email;
	private String sas_admin_approval_status;
	@Temporal(TemporalType.DATE)
	private Date sas_admin_approved_date;
	private String sas_admin_comments;
	private String nas_admin_email;
	private String nas_admin_approval_status;
	@Temporal(TemporalType.DATE)
	private Date nas_admin_approved_date;
	private String nas_admin_comments;
	private String bitbucket_admin_email;
	private String bitbucket_admin_approval_status;
	@Temporal(TemporalType.DATE)
	private Date bitbucket_admin_approved_date;
	private String bitbucket_admin_comments;
	private String status;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSas_admin_email() {
		return sas_admin_email;
	}

	public void setSas_admin_email(String sas_admin_email) {
		this.sas_admin_email = sas_admin_email;
	}

	public String getSas_admin_approval_status() {
		return sas_admin_approval_status;
	}

	public void setSas_admin_approval_status(String sas_admin_approval_status) {
		this.sas_admin_approval_status = sas_admin_approval_status;
	}

	public Date getSas_admin_approved_date() {
		return sas_admin_approved_date;
	}

	public void setSas_admin_approved_date(Date sas_admin_approved_date) {
		this.sas_admin_approved_date = sas_admin_approved_date;
	}

	public String getSas_admin_comments() {
		return sas_admin_comments;
	}

	public void setSas_admin_comments(String sas_admin_comments) {
		this.sas_admin_comments = sas_admin_comments;
	}

	public String getNas_admin_email() {
		return nas_admin_email;
	}

	public void setNas_admin_email(String nas_admin_email) {
		this.nas_admin_email = nas_admin_email;
	}

	public String getNas_admin_approval_status() {
		return nas_admin_approval_status;
	}

	public void setNas_admin_approval_status(String nas_admin_approval_status) {
		this.nas_admin_approval_status = nas_admin_approval_status;
	}

	public Date getNas_admin_approved_date() {
		return nas_admin_approved_date;
	}

	public void setNas_admin_approved_date(Date nas_admin_approved_date) {
		this.nas_admin_approved_date = nas_admin_approved_date;
	}

	public String getNas_admin_comments() {
		return nas_admin_comments;
	}

	public void setNas_admin_comments(String nas_admin_comments) {
		this.nas_admin_comments = nas_admin_comments;
	}

	public String getBitbucket_admin_email() {
		return bitbucket_admin_email;
	}

	public void setBitbucket_admin_email(String bitbucket_admin_email) {
		this.bitbucket_admin_email = bitbucket_admin_email;
	}

	public String getBitbucket_admin_approval_status() {
		return bitbucket_admin_approval_status;
	}

	public void setBitbucket_admin_approval_status(String bitbucket_admin_approval_status) {
		this.bitbucket_admin_approval_status = bitbucket_admin_approval_status;
	}

	public Date getBitbucket_admin_approved_date() {
		return bitbucket_admin_approved_date;
	}

	public void setBitbucket_admin_approved_date(Date bitbucket_admin_approved_date) {
		this.bitbucket_admin_approved_date = bitbucket_admin_approved_date;
	}

	public String getBitbucket_admin_comments() {
		return bitbucket_admin_comments;
	}

	public void setBitbucket_admin_comments(String bitbucket_admin_comments) {
		this.bitbucket_admin_comments = bitbucket_admin_comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Requests [row_id=" + row_id + ", bank_id=" + bank_id + ", name=" + name + ", request_date="
				+ request_date + ", request_id=" + request_id + ", request_item_id=" + request_item_id
				+ ", request_type=" + request_type + ", request_action=" + request_action + ", request_value="
				+ request_value + ", line_manager_email=" + line_manager_email + ", line_manager_approval_status="
				+ line_manager_approval_status + ", line_manager_approved_date=" + line_manager_approved_date
				+ ", line_manager_comments=" + line_manager_comments + ", domain_manager_email=" + domain_manager_email
				+ ", domain_manager_approval_status=" + domain_manager_approval_status
				+ ", domain_manager_approved_date=" + domain_manager_approved_date + ", domain_manager_comments="
				+ domain_manager_comments + ", sas_admin_email=" + sas_admin_email + ", sas_admin_approval_status="
				+ sas_admin_approval_status + ", sas_admin_approved_date=" + sas_admin_approved_date
				+ ", sas_admin_comments=" + sas_admin_comments + ", nas_admin_email=" + nas_admin_email
				+ ", nas_admin_approval_status=" + nas_admin_approval_status + ", nas_admin_approved_date="
				+ nas_admin_approved_date + ", nas_admin_comments=" + nas_admin_comments + ", bitbucket_admin_email="
				+ bitbucket_admin_email + ", bitbucket_admin_approval_status=" + bitbucket_admin_approval_status
				+ ", bitbucket_admin_approved_date=" + bitbucket_admin_approved_date + ", bitbucket_admin_comments="
				+ bitbucket_admin_comments + ", status=" + status + "]";
	}

}
