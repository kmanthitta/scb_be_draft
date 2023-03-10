package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserActiveAccesses;
import com.example.demo.entity.DomainManagerInfo;
import com.example.demo.entity.UserAccessRequests;
import com.example.demo.repository.UserActiveAccessesRepository;
import com.example.demo.repository.DomainManagerInfoRepository;
import com.example.demo.repository.UserAccessRequestsRepository;

@Service
public class UserAccessRequestsService {
	@Autowired
	UserAccessRequestsRepository repo;

	@Autowired
	UserActiveAccessesRepository activeAccRepo;

	@Autowired
	DomainManagerInfoRepository dmRepo;

	@Autowired
	UserActiveAccessesService activeAccSer;

	@Autowired
	DomainManagerInfoService domainManSer;

	@Value("${nasAdminMail}")
	private String nasAdminMail;

	@Value("${bbAdminMail}")
	private String bbAdminMail;

	@Value("${sasAdminMail}")
	private String sasAdminMail;

	public List<String> getDomains() {
		return domainManSer.getDomains();
	}

	public void submitNewRequest(Map<String, Object> payload) {
		generateRequest(payload);
	}

	public void modifyUser(Map<String, Object> payload) {
		generateRequest(payload);
	}

	public void deleteUser(String bankId) {
		List<UserActiveAccesses> accesses = activeAccSer.findActiveAccesses(bankId);
		buildRequestForDelete(accesses);
	}

	public void buildRequestForDelete(List<UserActiveAccesses> acc) {
		Integer count = acc.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bankId", acc.get(0).getBankId());
		map.put("name", "just another name");
		map.put("LMemail", acc.get(0).getLmEmail());
		map.put("DMemail", acc.get(0).getDmEmail());
		ArrayList<Map<String, Object>> requests = new ArrayList<Map<String, Object>>();
		requests.add(buildSingleRequest("Role", acc.get(0).getRole(), "Delete"));
		requests.add(buildSingleRequest("Location", acc.get(0).getLocation(), "Delete"));
		requests.add(buildSingleRequest("SAS Viya", acc.get(0).getSasViya(), "Delete"));
		for (int i = 0; i < count; i++) {
			requests.add(buildSingleRequest("Group", acc.get(i).getGroupName(), "Delete"));
		}
		map.put("requests", requests);
		generateRequest(map);
	}

	public Map<String, Object> buildSingleRequest(String type, String value, String action) {
		HashMap<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("type", type);
		reqMap.put("action", action);
		reqMap.put("value", value);
		return reqMap;
	}

	@SuppressWarnings("unchecked")
	public void generateRequest(Map<String, Object> payload) {
		Integer count = ((List<Map<String, Object>>) payload.get("requests")).size();
		Integer masterId = getUserReqCount((String) payload.get("bankId")) + 1;
		DomainManagerInfo dm = null;
		ArrayList<Map<String, Object>> req = (ArrayList<Map<String, Object>>) payload.get("requests");
		for (Map<String, Object> request : req) {
			if (StringUtils.equalsIgnoreCase(String.valueOf(request.get("type")), "Group")) {
				dm = dmRepo.getDomainManager(String.valueOf(request.get("type")));
			}
		}
		for (int i = 0; i < count; i++) {
			UserAccessRequests r = new UserAccessRequests();
			r.setBankId(String.valueOf(payload.get("bankId")));
			r.setName(String.valueOf(payload.get("name")));
			r.setRequestDate(new Date());
			r.setRequestId(masterId);
			r.setRequestItemId(i + 1);
			r.setRequestType(String.valueOf(req.get(i).get("type")));
			r.setRequestAction(String.valueOf(req.get(i).get("action")));
			r.setRequestValue(String.valueOf(req.get(i).get("value")));
			r.setLineManagerEmail(String.valueOf(payload.get("LMemail")));
			r.setLineManagerApprovalStatus("PENDING");
			r.setLineManagerApprovedDate(null);
			r.setLineManagerComments(null);
			r.setDomainManagerEmail(String.valueOf(dm.getEmail()));
			r.setDomainManagerApprovalStatus("PENDING");
			r.setDomainManagerApprovedDate(null);
			r.setDomainManagerComments(null);
			r.setStatus("UNDER APPROVAL");
			switch (String.valueOf(req.get(i).get("type"))) {
			case "Group":
				r.setNasAdminEmail(nasAdminMail);
				r.setNasAdminApprovalStatus("PENDING");
				r.setNasAdminApprovedDate(null);
				r.setNasAdminComments(null);
				r.setBitbucketAdminEmail(bbAdminMail);
				r.setBitbucketAdminApprovalStatus("PENDING");
				r.setBitbucketAdminApprovedDate(null);
				r.setBitbucketAdminComments(null);
				break;
			case "SAS Viya":
				r.setSasAdminEmail(sasAdminMail);
				r.setSasAdminApprovalStatus("PENDING");
				r.setSasAdminApprovedDate(null);
				r.setSasAdminComments(null);
				break;
			}
			repo.save(r);
		}
		// mailLM()
	}

	public List<Map<String, Object>> getRequests(String email, String category) {
		List<UserAccessRequests> obj = new ArrayList<UserAccessRequests>();
		List<Map<String, Object>> reqList = new ArrayList<>();
		switch (category) {
		case "lineManager":
			obj = repo.findOpenRequestsForLM(email);
			for (UserAccessRequests req : obj) {
				Map<String, Object> request = new HashMap<>();
				request.put("id", req.getRowId());
				request.put("bankId", req.getBankId());
				request.put("name", req.getName());
				request.put("requestDate", req.getRequestDate());
				request.put("type", req.getRequestType());
				request.put("action", req.getRequestAction());
				request.put("value", req.getRequestValue());
				reqList.add(request);
			}
			break;
		case "domainManager":
			obj = repo.findOpenRequestsForDM(email);
			for (UserAccessRequests req : obj) {
				Map<String, Object> request = new HashMap<>();
				request.put("id", req.getRowId());
				request.put("bankId", req.getBankId());
				request.put("name", req.getName());
				request.put("requestDate", req.getRequestDate());
				request.put("type", req.getRequestType());
				request.put("action", req.getRequestAction());
				request.put("value", req.getRequestValue());
				request.put("lmApprovedDate", req.getLineManagerApprovedDate());
				reqList.add(request);
			}
			break;
		case "admin":
			obj = repo.findOpenRequestsForAdmin(email);
			for (UserAccessRequests req : obj) {
				Map<String, Object> request = new HashMap<>();
				request.put("id", req.getRowId());
				request.put("bankId", req.getBankId());
				request.put("name", req.getName());
				request.put("requestDate", req.getRequestDate());
				request.put("type", req.getRequestType());
				request.put("action", req.getRequestAction());
				request.put("value", req.getRequestValue());
				request.put("lmApprovedDate", req.getLineManagerApprovedDate());
				request.put("dmApprovedDate", req.getDomainManagerApprovedDate());
				reqList.add(request);
			}
			break;
		}
		return reqList;
	}

	public List<Map<String, Object>> getOpenRequests(String bankId) {
		List<UserAccessRequests> obj = new ArrayList<UserAccessRequests>();
		List<Map<String, Object>> reqList = new ArrayList<>();
		obj = repo.findOpenRequests(bankId);
		for (UserAccessRequests req : obj) {
			Map<String, Object> request = new HashMap<>();
			request.put("requestDate", req.getRequestDate());
			request.put("type", req.getRequestType());
			request.put("action", req.getRequestAction());
			request.put("value", req.getRequestValue());
			Map<String, Map<String, Object>> allStatus = new HashMap<>();
			Map<String, Object> lmStatus = buildStatusObject("LM", req);
			Map<String, Object> dmStatus = buildStatusObject("DM", req);
			Map<String, Object> sasStatus = buildStatusObject("SAS", req);
			Map<String, Object> nasStatus = buildStatusObject("NAS", req);
			Map<String, Object> bitbucketStatus = buildStatusObject("BB", req);
			allStatus.put("LM", lmStatus);
			allStatus.put("DM", dmStatus);
			allStatus.put("SAS", sasStatus);
			allStatus.put("NAS", nasStatus);
			allStatus.put("BB", bitbucketStatus);
			request.put("allStatuses", allStatus);
			reqList.add(request);
		}
		return reqList;
	}

	public Map<String, Object> buildStatusObject(String category, UserAccessRequests req) {
		Map<String, Object> status = new HashMap<>();
		switch (category) {
		case "LM":
			if (Objects.nonNull(req.getLineManagerEmail())) {
				status.put("email", req.getLineManagerEmail());
				status.put("status", req.getLineManagerApprovalStatus());
				status.put("approvedDate", req.getLineManagerApprovedDate());
				status.put("comments", req.getLineManagerComments());
			} else {
				status = null;
			}
			break;
		case "DM":
			if (Objects.nonNull(req.getDomainManagerEmail())) {
				status.put("email", req.getDomainManagerEmail());
				status.put("status", req.getDomainManagerApprovalStatus());
				status.put("approvedDate", req.getDomainManagerApprovedDate());
				status.put("comments", req.getDomainManagerComments());
			} else {
				status = null;
			}
			break;
		case "SAS":
			if (Objects.nonNull(req.getSasAdminEmail())) {
				status.put("email", req.getSasAdminEmail());
				status.put("status", req.getSasAdminApprovalStatus());
				status.put("approvedDate", req.getSasAdminApprovedDate());
				status.put("comments", req.getSasAdminComments());
			} else {
				status = null;
			}
			break;
		case "NAS":
			if (Objects.nonNull(req.getNasAdminEmail())) {
				status.put("email", req.getNasAdminEmail());
				status.put("status", req.getNasAdminApprovalStatus());
				status.put("approvedDate", req.getNasAdminApprovedDate());
				status.put("comments", req.getNasAdminComments());
			} else {
				status = null;
			}
			break;
		case "BB":
			if (Objects.nonNull(req.getBitbucketAdminEmail())) {
				status.put("email", req.getBitbucketAdminEmail());
				status.put("status", req.getBitbucketAdminApprovalStatus());
				status.put("approvedDate", req.getBitbucketAdminApprovedDate());
				status.put("comments", req.getBitbucketAdminComments());
			} else {
				status = null;
			}
			break;
		}
		return status;
	}

	public List<UserAccessRequests> getClosedRequests(String bankId) {
		return repo.findClosedRequests(bankId);
	}

	public Integer getUserReqCount(String bankId) {
		Integer t = repo.getUserReqCount(bankId);
		if (Objects.isNull(t)) {
			return 0;
		} else {
			return t;
		}
	}

	@SuppressWarnings("unchecked")
	public void approveRequest(Map<String, Object> payload) {
		String type = String.valueOf(payload.get("type"));
		String email = String.valueOf(payload.get("email"));
		ArrayList<Map<String, Object>> requestIDs = (ArrayList<Map<String, Object>>) payload.get("requestIDs");
		switch (type) {
		case "LM":
			for (Map<String, Object> req : requestIDs) {
				UserAccessRequests r = repo.findByRowId((Integer) req.get("id"));
				r.setLineManagerComments(String.valueOf(req.get("comments")));
				r.setLineManagerApprovalStatus(String.valueOf(req.get("action")));
				if (StringUtils.equalsIgnoreCase(String.valueOf(req.get("action")), "REJECTED")) {
					r.setStatus("REJECTED");
				}
				r.setLineManagerApprovedDate(new Date());
				repo.save(r);
			}
			// send mail to dm
			// handle rejection
			break;
		case "DM":
			for (Map<String, Object> req : requestIDs) {
				UserAccessRequests r = repo.findByRowId((Integer) req.get("id"));
				r.setDomainManagerComments(String.valueOf(req.get("comments")));
				r.setDomainManagerApprovalStatus(String.valueOf(req.get("action")));
				if (StringUtils.equalsIgnoreCase(String.valueOf(req.get("action")), "REJECTED")) {
					r.setStatus("REJECTED");
				}
				r.setDomainManagerApprovedDate(new Date());
				repo.save(r);
			}
			// send mail to admins
			// handle rejection
			break;
		case "Admin":
			String admin = "";
			if (StringUtils.equalsIgnoreCase(email, nasAdminMail)) {
				admin = "NAS";
			} else if (StringUtils.equalsIgnoreCase(email, bbAdminMail)) {
				admin = "BB";
			} else {
				admin = "SAS";
			}
			switch (admin) {
			case "SAS":
				for (Map<String, Object> req : requestIDs) {
					UserAccessRequests r = repo.findByRowId((Integer) req.get("id"));
					r.setSasAdminComments(String.valueOf(req.get("comments")));
					r.setSasAdminApprovalStatus(String.valueOf(req.get("action")));
					r.setSasAdminApprovedDate(new Date());
					repo.save(r);
				}
				// send mail??
				break;
			case "NAS":
				for (Map<String, Object> req : requestIDs) {
					UserAccessRequests r = repo.findByRowId((Integer) req.get("id"));
					r.setNasAdminComments(String.valueOf(req.get("comments")));
					r.setNasAdminApprovalStatus(String.valueOf(req.get("action")));
					r.setNasAdminApprovedDate(new Date());
					repo.save(r);
				}
				// send mail??
				break;
			case "BB":
				for (Map<String, Object> req : requestIDs) {
					UserAccessRequests r = repo.findByRowId((Integer) req.get("id"));
					r.setBitbucketAdminComments(String.valueOf(req.get("comments")));
					r.setBitbucketAdminApprovalStatus(String.valueOf(req.get("action")));
					r.setBitbucketAdminApprovedDate(new Date());
					repo.save(r);
				}
				// send mail??
				break;
			}
			break;
		}
	}
}
