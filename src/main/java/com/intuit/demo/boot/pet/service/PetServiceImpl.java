package com.intuit.demo.boot.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.db.Repository;

@Component
public class PetServiceImpl implements PetService{

	@Autowired
	Repository respository;
	
	
	public PetServiceImpl(Repository respository) {
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
