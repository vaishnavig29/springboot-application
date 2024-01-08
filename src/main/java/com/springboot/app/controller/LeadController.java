package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.springboot.app.exception.LeadAlreadyExistsException;
import com.springboot.app.model.Lead;
import com.springboot.app.response.ApiResponse;
import com.springboot.app.service.LeadService;

@RestController
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("Hello World");
	}
	
	@PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> createLead(@RequestBody Lead lead) {
        try {
            Lead createdLead = leadService.createLead(lead);
            return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<String>("success", "Created Leads Successfully"));
        } catch (LeadAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<String>("error", "E10010", e.getMessage()));
        }
    }
	
	@GetMapping("/fetch")
    public ResponseEntity<ApiResponse<List<Lead>>> fetchLeadsByMobileNumber(@RequestParam("mobileNumber") String mobileNumber) {
        List<Lead> leads = leadService.findLeadsByMobileNumber(mobileNumber);

        if (leads.isEmpty()) {
            ApiResponse<List<Lead>> apiResponse = new ApiResponse<List<Lead>>("error", "E10011", "No Lead found with the Mobile Number " + mobileNumber);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(apiResponse);
        }

        ApiResponse<List<Lead>> apiResponse = new ApiResponse<List<Lead>>("success", leads);
        return ResponseEntity.ok().body(apiResponse);
    }

}
