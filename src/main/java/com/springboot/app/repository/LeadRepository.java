package com.springboot.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.Lead;
@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
	Lead findByLeadId(int leadId);
    Lead findByEmail(String email);
    List<Lead> findByMobileNumber(String mobileNumber);

}
