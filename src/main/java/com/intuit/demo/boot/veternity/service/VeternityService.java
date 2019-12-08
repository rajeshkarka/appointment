package com.intuit.demo.boot.veternity.service;

import java.util.List;

import com.intuit.demo.boot.appointment.model.VeternityClinic;

public interface VeternityService {

	Long addVeternity(VeternityClinic veternity);
	
	VeternityClinic getVeternity(Long veternityId);
	
	List<VeternityClinic> getAllClinics();
}
