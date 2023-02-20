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
	private Integer rowId;
	private String bankId;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date requestDate;
	private Integer requestId;
	private Integer requestItemId;
	private String requestType;
	private String requestAction;
	private String requestValue;
	private String lineManagerEmail;
	private String lineManagerApprovalStatus;
	@Temporal(TemporalType.DATE)
	private Date lineManagerApprovedDate;
	private String lineManagerComments;
	private String domainManagerEmail;
	private String domainManagerApprovalStatus;
	@Temporal(TemporalType.DATE)
	private Date domainManagerApprovedDate;
	private String domainManagerComments;
	private String sasAdminEmail;
	private String sasAdminApprovalStatus;
	@Temporal(TemporalType.DATE)
	private Date sasAdminApprovedDate;
	private String sasAdminComments;
	private String nasAdminEmail;
	private String nasAdminApprovalStatus;
	@Temporal(TemporalType.DATE)
	private Date nasAdminApprovedDate;
	private String nasAdminComments;
	private String bitbucketAdminEmail;
	private String bitbucketAdminApprovalStatus;
	@Temporal(TemporalType.DATE)
	private Date bitbucketAdminApprovedDate;
	private String bitbucketAdminComments;
	private String status;

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date date) {
		this.requestDate = date;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getRequestItemId() {
		return requestItemId;
	}

	public void setRequestItemId(Integer requestItemId) {
		this.requestItemId = requestItemId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestAction() {
		return requestAction;
	}

	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}

	public String getRequestValue() {
		return requestValue;
	}

	public void setRequestValue(String requestValue) {
		this.requestValue = requestValue;
	}

	public String getLineManagerEmail() {
		return lineManagerEmail;
	}

	public void setLineManagerEmail(String lineManagerEmail) {
		this.lineManagerEmail = lineManagerEmail;
	}

	public String getLineManagerApprovalStatus() {
		return lineManagerApprovalStatus;
	}

	public void setLineManagerApprovalStatus(String lineManagerApprovalStatus) {
		this.lineManagerApprovalStatus = lineManagerApprovalStatus;
	}

	public Date getLineManagerApprovedDate() {
		return lineManagerApprovedDate;
	}

	public void setLineManagerApprovedDate(Date lineManagerApprovedDate) {
		this.lineManagerApprovedDate = lineManagerApprovedDate;
	}

	public String getLineManagerComments() {
		return lineManagerComments;
	}

	public void setLineManagerComments(String lineManagerComments) {
		this.lineManagerComments = lineManagerComments;
	}

	public String getDomainManagerEmail() {
		return domainManagerEmail;
	}

	public void setDomainManagerEmail(String domainManagerEmail) {
		this.domainManagerEmail = domainManagerEmail;
	}

	public String getDomainManagerApprovalStatus() {
		return domainManagerApprovalStatus;
	}

	public void setDomainManagerApprovalStatus(String domainManagerApprovalStatus) {
		this.domainManagerApprovalStatus = domainManagerApprovalStatus;
	}

	public Date getDomainManagerApprovedDate() {
		return domainManagerApprovedDate;
	}

	public void setDomainManagerApprovedDate(Date domainManagerApprovedDate) {
		this.domainManagerApprovedDate = domainManagerApprovedDate;
	}

	public String getDomainManagerComments() {
		return domainManagerComments;
	}

	public void setDomainManagerComments(String domainManagerComments) {
		this.domainManagerComments = domainManagerComments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSasAdminEmail() {
		return sasAdminEmail;
	}

	public void setSasAdminEmail(String sasAdminEmail) {
		this.sasAdminEmail = sasAdminEmail;
	}

	public String getSasAdminApprovalStatus() {
		return sasAdminApprovalStatus;
	}

	public void setSasAdminApprovalStatus(String sasAdminApprovalStatus) {
		this.sasAdminApprovalStatus = sasAdminApprovalStatus;
	}

	public Date getSasAdminApprovedDate() {
		return sasAdminApprovedDate;
	}

	public void setSasAdminApprovedDate(Date sasAdminApprovedDate) {
		this.sasAdminApprovedDate = sasAdminApprovedDate;
	}

	public String getSasAdminComments() {
		return sasAdminComments;
	}

	public void setSasAdminComments(String sasAdminComments) {
		this.sasAdminComments = sasAdminComments;
	}

	public String getNasAdminEmail() {
		return nasAdminEmail;
	}

	public void setNasAdminEmail(String nasAdminEmail) {
		this.nasAdminEmail = nasAdminEmail;
	}

	public String getNasAdminApprovalStatus() {
		return nasAdminApprovalStatus;
	}

	public void setNasAdminApprovalStatus(String nasAdminApprovalStatus) {
		this.nasAdminApprovalStatus = nasAdminApprovalStatus;
	}

	public Date getNasAdminApprovedDate() {
		return nasAdminApprovedDate;
	}

	public void setNasAdminApprovedDate(Date nasAdminApprovedDate) {
		this.nasAdminApprovedDate = nasAdminApprovedDate;
	}

	public String getNasAdminComments() {
		return nasAdminComments;
	}

	public void setNasAdminComments(String nasAdminComments) {
		this.nasAdminComments = nasAdminComments;
	}

	public String getBitbucketAdminEmail() {
		return bitbucketAdminEmail;
	}

	public void setBitbucketAdminEmail(String bitbucketAdminEmail) {
		this.bitbucketAdminEmail = bitbucketAdminEmail;
	}

	public String getBitbucketAdminApprovalStatus() {
		return bitbucketAdminApprovalStatus;
	}

	public void setBitbucketAdminApprovalStatus(String bitbucketAdminApprovalStatus) {
		this.bitbucketAdminApprovalStatus = bitbucketAdminApprovalStatus;
	}

	public Date getBitbucketAdminApprovedDate() {
		return bitbucketAdminApprovedDate;
	}

	public void setBitbucketAdminApprovedDate(Date bitbucketAdminApprovedDate) {
		this.bitbucketAdminApprovedDate = bitbucketAdminApprovedDate;
	}

	public String getBitbucketAdminComments() {
		return bitbucketAdminComments;
	}

	public void setBitbucketAdminComments(String bitbucketAdminComments) {
		this.bitbucketAdminComments = bitbucketAdminComments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Requests [row_id=" + rowId + ", bankId=" + bankId + ", name=" + name + ", request_date="
				+ requestDate + ", request_id=" + requestId + ", request_item_id=" + requestItemId
				+ ", request_type=" + requestType + ", request_action=" + requestAction + ", request_value="
				+ requestValue + ", line_manager_email=" + lineManagerEmail + ", line_manager_approval_status="
				+ lineManagerApprovalStatus + ", lineManagerApprovedDate=" + lineManagerApprovedDate
				+ ", lineManagerComments=" + lineManagerComments + ", domainManagerEmail=" + domainManagerEmail
				+ ", domainManagerApprovalStatus=" + domainManagerApprovalStatus
				+ ", domainManagerApprovedDate=" + domainManagerApprovedDate + ", domainManagerComm="
				+ domainManagerComments + ", sasAdminEmail=" + sasAdminEmail + ", sasAdminApprovalStatus="
				+ sasAdminApprovalStatus + ", sasAdminApprovedDate=" + sasAdminApprovedDate
				+ ", sasAdminComments=" + sasAdminComments + ", nasAdminEmail=" + nasAdminEmail
				+ ", nasAdminApprovalStatus=" + nasAdminApprovalStatus + ", nasAdminApprovedDate="
				+ nasAdminApprovedDate + ", nasAdminComments=" + nasAdminComments + ", bitbucketAdminEmail="
				+ bitbucketAdminEmail + ", bitbucketAdminApprovalStatus=" + bitbucketAdminApprovalStatus
				+ ", bitbucketAdminApprovedDate=" + bitbucketAdminApprovedDate + ", bitbucketAdminComments="
				+ bitbucketAdminComments + ", status=" + status + "]";
	}

}
