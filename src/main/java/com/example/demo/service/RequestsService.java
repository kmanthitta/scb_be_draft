package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ActiveAccesses;
import com.example.demo.entity.Requests;
import com.example.demo.repository.ActiveAccessesRepository;
import com.example.demo.repository.RequestsRepository;

@Service
public class RequestsService {
	@Autowired
	RequestsRepository repo;

	@Autowired
	ActiveAccessesRepository activeAccRepo;

	@Autowired
	ActiveAccessesService activeAccSer;
	
	@Autowired
	DomainManagerInformationService domainManSer;

	@Value("${nasAdminMail}")
	private String nasAdminMail;

	@Value("${bbAdminMail}")
	private String bbAdminMail;

	@Value("${sasAdminMail}")
	private String sasAdminMail;
	
	public List<String> getDomains(){
		return domainManSer.getDomains();
	}

	public void submitNewRequest(Map<String, Object> payload) {
		generateRequest(payload);
	}

	public void modifyUser(Map<String, Object> payload) {
		generateRequest(payload);
	}

	public void deleteUser(String bankId) {
		List<ActiveAccesses> accesses = activeAccSer.findActiveAccesses(bankId);
		buildRequestForDelete(accesses);
	}

	public void buildRequestForDelete(List<ActiveAccesses> acc) {
		Integer count = acc.size();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bankId", acc.get(0).getBank_id());
		map.put("name", "just another name");
		map.put("LMemail", acc.get(0).getLmEmail());
		map.put("DMemail", acc.get(0).getDmEmail());
		ArrayList<Map<String, Object>> requests = new ArrayList<Map<String, Object>>();
		requests.add(buildSingleRequest("Role", acc.get(0).getRole(), "Delete"));
		requests.add(buildSingleRequest("Location", acc.get(0).getLocation(), "Delete"));
		requests.add(buildSingleRequest("SAS Viya", acc.get(0).getSas_viya(), "Delete"));
		for (int i = 0; i < count; i++) {
			requests.add(buildSingleRequest("Group", acc.get(i).getGroup_name(), "Delete"));
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
		ArrayList<Map<String, Object>> req = (ArrayList<Map<String, Object>>) payload.get("requests");
		// findDM()
		for (int i = 0; i < count; i++) {
			Requests r = new Requests();
			r.setBankId((String) payload.get("bankId"));
			r.setName((String) payload.get("name"));
			r.setRequestDate(new Date());
			r.setRequestId(masterId);
			r.setRequestItemId(i + 1);
			r.setRequestType((String) req.get(i).get("type"));
			r.setRequestAction((String) req.get(i).get("action"));
			r.setRequestValue((String) req.get(i).get("value"));
			r.setLineManagerEmail((String) payload.get("LMemail"));
			r.setLineManagerApprovalStatus("PENDING");
			r.setLineManagerApprovedDate(null);
			r.setLineManagerComments(null);
			r.setDomainManagerEmail((String) payload.get("DMemail"));
			r.setDomainManagerApprovalStatus("PENDING");
			r.setDomainManagerApprovedDate(null);
			r.setDomainManagerComments(null);
			r.setStatus("UNDER APPROVAL");
			switch ((String) req.get(i).get("type")) {
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

	public List<Requests> getRequests(String email, String category) {
		List<Requests> obj = new ArrayList<Requests>();
		switch (category) {
		case "lineManager":
			obj = repo.findOpenRequestsForLM(email);
			break;
		case "domainManager":
			obj = repo.findOpenRequestsForDM(email);
			break;
		case "admin":
			obj = repo.findOpenRequestsForAdmin(email);
			break;
		}
		System.out.println(obj);
		return obj;
	}
	
	public List<Requests> getOpenRequests(String bankId) {
		return repo.findOpenRequests(bankId);
	}

	public List<Requests> getClosedRequests(String bankId) {
		return repo.findClosedRequests(bankId);
	}

	public Integer getUserReqCount(String bankId) {
		Integer t = repo.getUserReqCount(bankId);
		if (t == null) {
			return 0;
		} else {
			return t;
		}
	}

	@SuppressWarnings("unchecked")
	public void approveRequest(Map<String, Object> payload) {
		String type = (String) payload.get("type");
		String email = (String) payload.get("email");
		ArrayList<Map<String, Object>> requestIDs = (ArrayList<Map<String, Object>>) payload.get("requestIDs");
		switch (type) {
		case "LM":
			for (Map<String, Object> req : requestIDs) {
				Requests r = repo.findByRowId((Integer) req.get("id"));
				r.setLineManagerComments((String) req.get("comments"));
				r.setLineManagerApprovalStatus((String) req.get("action"));
				if ((String) req.get("action") == "REJECTED") {
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
				Requests r = repo.findByRowId((Integer) req.get("id"));
				r.setDomainManagerComments((String) req.get("comments"));
				r.setDomainManagerApprovalStatus((String) req.get("action"));
				if ((String) req.get("action") == "REJECTED") {
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
			if (email == nasAdminMail) {
				admin = "NAS";
			} else if (email == bbAdminMail) {
				admin = "BB";
			} else {
				admin = "SAS";
			}
			switch (admin) {
			case "SAS":
				for (Map<String, Object> req : requestIDs) {
					Requests r = repo.findByRowId((Integer) req.get("id"));
					r.setSasAdminComments((String) req.get("comments"));
					r.setSasAdminApprovalStatus((String) req.get("action"));
					r.setSasAdminApprovedDate(new Date());
					repo.save(r);
				}
				// send mail??
				break;
			case "NAS":
				for (Map<String, Object> req : requestIDs) {
					Requests r = repo.findByRowId((Integer) req.get("id"));
					r.setNasAdminComments((String) req.get("comments"));
					r.setNasAdminApprovalStatus((String) req.get("action"));
					r.setNasAdminApprovedDate(new Date());
					repo.save(r);
				}
				// send mail??
				break;
			case "BB":
				for (Map<String, Object> req : requestIDs) {
					Requests r = repo.findByRowId((Integer) req.get("id"));
					r.setBitbucketAdminComments((String) req.get("comments"));
					r.setBitbucketAdminApprovalStatus((String) req.get("action"));
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
