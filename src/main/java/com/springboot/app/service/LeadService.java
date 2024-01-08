package com.springboot.app.service;



import java.util.List;

import com.springboot.app.model.Lead;


public interface LeadService {
	Lead createLead(Lead lead);
	List<Lead> findLeadsByMobileNumber(String mobileNumber);
	
	
}
