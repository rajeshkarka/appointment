package com.intuit.demo.boot.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.boot.appointment.repository.AppointmentRepository;

@Component
public class PetServiceImpl implements PetService{

	@Autowired
	AppointmentRepository respository;
	
	
	public PetServiceImpl(AppointmentRepository respository) {
		this.respository = respository;
	}

	@Override
	public Long addPet(Pet pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet getPet(Long petId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> getAllPets(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
