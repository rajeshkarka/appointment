package com.intuit.demo.boot.veternity.service;

import java.util.List;

import com.intuit.demo.boot.appointment.model.VeterinaryClinic;

public interface VeternityService {

	Long addVeternity(VeterinaryClinic veternity);
	
	VeterinaryClinic getVeternity(Long veternityId);
	
	List<VeterinaryClinic> getAllClinics();
}
