package com.intuit.demo.boot.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.boot.appointment.repository.AppointmentRepository;
import com.intuit.demo.boot.appointment.repository.PetRepository;

@Component
public class PetServiceImpl implements PetService{

	@Autowired
	PetRepository petRepository;
	
	
	public PetServiceImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Long addPet(Pet pet) {
		pet = petRepository.save(pet);
		return null;
	}

	@Override
	public Pet getPet(Long petId) {
		return petRepository.getOne(petId);
	}

	@Override
	public List<Pet> getAllPets(Long userId) {
		return petRepository.findAll();
	}

	@Override
	public void delete(Long petId) {
		Pet pet=getPet(petId);
		petRepository.delete(pet);
	}

}
