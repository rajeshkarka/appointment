package com.intuit.demo.boot.veternity.service;

import java.util.List;

import com.intuit.demo.boot.appointment.model.Veterinary;

public interface VeterinaryService {

	Veterinary addVeternity(Veterinary veternity);
	
	Veterinary getVeternity(Long veternityId);
	
	List<Veterinary> getAllClinics();
	
	void delete(Long vetId);
}
