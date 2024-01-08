package com.springboot.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.springboot.app.exception.LeadAlreadyExistsException;
import com.springboot.app.model.Lead;
import com.springboot.app.repository.LeadRepository;

import com.springboot.app.service.LeadService;

@RunWith(MockitoJUnitRunner.class)
public class LeadServiceTest {
	
	@InjectMocks
    private LeadService leadService;

    @Mock
    private LeadRepository leadRepository;

    @Test
    public void testCreateLead_Success() throws LeadAlreadyExistsException {
        Lead lead = new Lead();

        Mockito.when(leadRepository.findByLeadId(lead.getLeadId())).thenReturn(null);
        Mockito.when(leadRepository.findByEmail(lead.getEmail())).thenReturn(null);
        Mockito.when(leadRepository.save(lead)).thenReturn(lead);

        Lead createdLead = leadService.createLead(lead);

        assertNotNull(createdLead);
        
    }

    @Test(expected = LeadAlreadyExistsException.class)
    public void testCreateLead_LeadAlreadyExistsById() throws LeadAlreadyExistsException {
        Lead lead = new Lead();

        Mockito.when(leadRepository.findByLeadId(lead.getLeadId())).thenReturn(lead);

        leadService.createLead(lead);
    }

    @Test(expected = LeadAlreadyExistsException.class)
    public void testCreateLead_LeadAlreadyExistsByEmail() throws LeadAlreadyExistsException {
        Lead lead = new Lead();

        Mockito.when(leadRepository.findByLeadId(lead.getLeadId())).thenReturn(null);
        Mockito.when(leadRepository.findByEmail(lead.getEmail())).thenReturn(lead);

        leadService.createLead(lead);
    }


	   
}
