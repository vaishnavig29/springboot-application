package com.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.exception.LeadAlreadyExistsException;
import com.springboot.app.model.Lead;
import com.springboot.app.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService{
	@Autowired
	private LeadRepository leadRepository;

	public Lead createLead(Lead lead) {
		Lead existingLead= leadRepository.findByLeadId(lead.getLeadId());
		if (existingLead != null) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the lead id");
        }
		Lead existingLeadByEmail = leadRepository.findByEmail(lead.getEmail());
        if (existingLeadByEmail !=null) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the email");
        }
        return leadRepository.save(lead);
	}

	public List<Lead> findLeadsByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return leadRepository.findByMobileNumber(mobileNumber);
	}

}
