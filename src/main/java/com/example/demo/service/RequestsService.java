package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		//findDM()
		//findAdminsifApplicable()
		for (int i = 0; i < count; i++) {
			Requests r = new Requests();
			r.setBank_id((String) payload.get("bankId"));
			r.setName((String) payload.get("email"));
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
			r.setSas_admin_email(null);
			r.setSas_admin_approval_status("PENDING");
			r.setSas_admin_approved_date(null);
			r.setSas_admin_comments(null);
			r.setNas_admin_email(null);
			r.setNas_admin_approval_status("PENDING");
			r.setNas_admin_approved_date(null);
			r.setNas_admin_comments(null);
			r.setBitbucket_admin_email(null);
			r.setBitbucket_admin_approval_status("PENDING");
			r.setBitbucket_admin_approved_date(null);
			r.setBitbucket_admin_comments(null);
			repo.save(r);
		}
		//mailLM()
	}

	public void checkDuplicateRequest(Map<String, Object> req, String bankId) {
		activeAccSer.findActiveAccesses(bankId);
	}
}
