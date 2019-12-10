package com.intuit.demo.boot.pet.service;

import java.util.List;

import com.intuit.demo.boot.appointment.model.Pet;

public interface PetService {

	Long addPet(Pet pet);

	Pet getPet(Long petId);

	List<Pet> getAllPets(Long userId);

	void delete(Long petId);
}
