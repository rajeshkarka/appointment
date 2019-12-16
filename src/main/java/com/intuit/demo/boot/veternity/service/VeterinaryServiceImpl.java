package com.intuit.demo.boot.veternity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.boot.appointment.model.Veterinary;
import com.intuit.demo.boot.appointment.repository.VeterinaryRepository;

@Component
public class VeterinaryServiceImpl implements VeterinaryService {

	@Autowired
	VeterinaryRepository veterinaryRepository;

	public VeterinaryServiceImpl(VeterinaryRepository veterinaryRepository) {
		this.veterinaryRepository=veterinaryRepository;
	}
	@Override
	public Veterinary addVeternity(Veterinary veterinary) {

		return veterinaryRepository.save(veterinary);
	}

	@Override
	public Veterinary getVeternity(Long veterinaryId) {
		return veterinaryRepository.getOne(veterinaryId);
	}

	@Override
	public List<Veterinary> getAllClinics() {
		return veterinaryRepository.findAll();
	}

	@Override
	public void delete(Long vetId) {
		Veterinary veterinary = veterinaryRepository.getOne(vetId);
		if (veterinary != null) {
			veterinaryRepository.delete(veterinary);
		}
	}

}
