package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

	@SuppressWarnings("unchecked")
	public void submitNewRequest(Map<String, Object> payload) {
		Integer count = ((List<Map<String, Object>>) payload.get("requests")).size();
		Integer masterId = repo.getCount();
		ArrayList<Map<String, Object>> req = (ArrayList<Map<String, Object>>) payload.get("requests");
		// findDM()
		// findAdminsifApplicablefromconfig()
		for (int i = 0; i < count; i++) {
			Requests r = new Requests();
			r.setBank_id((String) payload.get("bankId"));
			r.setName((String) payload.get("name"));
			r.setRequest_date(new Date());
			r.setRequest_id(masterId);
			r.setRequest_item_id(i + 1);
			r.setRequest_type((String) req.get(i).get("type"));
			r.setRequest_action((String) req.get(i).get("action"));
			r.setRequest_value((String) req.get(i).get("value"));
			r.setLine_manager_email((String) payload.get("LMemail"));
			r.setLine_manager_approval_status("PENDING");
			r.setLine_manager_approved_date(null);
			r.setLine_manager_comments(null);
			r.setDomain_manager_email((String) payload.get("DMemail"));
			r.setDomain_manager_approval_status("PENDING");
			r.setDomain_manager_approved_date(null);
			r.setDomain_manager_comments(null);
			switch ((String) req.get(i).get("type")) {
			case "Group":
				r.setNas_admin_email("NAS MAIL");
				r.setNas_admin_approval_status("PENDING");
				r.setNas_admin_approved_date(null);
				r.setNas_admin_comments(null);
				r.setBitbucket_admin_email("BB MAIL");
				r.setBitbucket_admin_approval_status("PENDING");
				r.setBitbucket_admin_approved_date(null);
				r.setBitbucket_admin_comments(null);
				break;
			case "SAS Viya":
				r.setSas_admin_email("SAS MAIL");
				r.setSas_admin_approval_status("PENDING");
				r.setSas_admin_approved_date(null);
				r.setSas_admin_comments(null);
				break;
			}
			repo.save(r);
		}
		// mailLM()
	}

	public void deleteUser(String bankId) {
		List<ActiveAccesses> accesses = activeAccSer.findActiveAccesses(bankId);
		buildRequestForDelete(accesses);
	}

	public void buildRequestForDelete(List<ActiveAccesses> acc) {
		Integer count = acc.size();
		Integer masterId = repo.getCount();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bankId", acc.get(0).getBank_id());
		map.put("name", "just another name");
		map.put("LMEMail", acc.get(0).getLm_email());
		map.put("DMEmail", acc.get(0).getDm_email());
		ArrayList<Map<String, Object>> requests = new ArrayList<Map<String,Object>>();
		requests.add(buildSingleRequest("Role", acc.get(0).getRole(), "Delete"));
		requests.add(buildSingleRequest("Location", acc.get(0).getLocation(), "Delete"));
		requests.add(buildSingleRequest("SAS Viya", acc.get(0).getSas_viya(), "Delete"));
		for (int i = 0; i < count; i++) {
			requests.add(buildSingleRequest("Group", acc.get(i).getGroup_name(), "Delete"));
		}
		map.put("requests", requests);
		System.out.println(map);
	}

	public Map<String, Object> buildSingleRequest(String type, String value, String action) {
		HashMap<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("type", type);
		reqMap.put("action", action);
		reqMap.put("value", value);
		return reqMap;
	}

}
