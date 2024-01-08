package com.springboot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.app.controller.LeadController;
import com.springboot.app.exception.LeadAlreadyExistsException;
import com.springboot.app.model.Lead;
import com.springboot.app.response.ApiResponse;
import com.springboot.app.service.LeadService;

@RunWith(SpringRunner.class)

@SpringBootTest
public class LeadControllerTest {

	@InjectMocks
	private LeadController leadController;

	@Mock
	private LeadService leadService;

	@Test
	public void testCreateLead_Success() throws LeadAlreadyExistsException {
		Lead lead = new Lead();

		Mockito.when(leadService.createLead(Mockito.any(Lead.class))).thenReturn(lead);

		ResponseEntity<ApiResponse<String>> response = leadController.createLead(lead);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("success", response.getBody().getStatus());

	}

	@Test
	public void testCreateLead_AlreadyExistsException() throws LeadAlreadyExistsException {
		Lead lead = new Lead();

		Mockito.doThrow(new LeadAlreadyExistsException("Lead Already Exists")).when(leadService).createLead(lead);

		ResponseEntity<ApiResponse<String>> response = leadController.createLead(lead);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("error", response.getBody().getStatus());

	}

	@Test
	public void testFetchLeadsByMobileNumber_Success() {
		String mobileNumber = "1234567890";
		List<Lead> leads = new ArrayList();
		Mockito.when(leadService.findLeadsByMobileNumber(mobileNumber)).thenReturn(leads);

		ResponseEntity<ApiResponse<List<Lead>>> response = leadController.fetchLeadsByMobileNumber(mobileNumber);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("success", response.getBody().getStatus());

	}


}
