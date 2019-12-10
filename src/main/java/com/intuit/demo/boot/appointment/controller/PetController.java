package com.intuit.demo.boot.appointment.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.boot.pet.service.PetService;

import sun.security.provider.certpath.OCSPResponse.ResponseStatus;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

	@Autowired(required=false)
	@Qualifier("petService")
	private PetService petService;
	
	
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@RequestMapping(path = "/my/{userId}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> getByUserId(@PathVariable Long userId) {
        return petService.getAllPets(userId);
    }
	
	@RequestMapping(path = "/{petId}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getById(@PathVariable Long petId) {
        return new ResponseEntity<Pet>(petService.getPet(petId),HttpStatus.OK);
        
    }
	
	@PostMapping(path = "/{userId}/add")
    public Long save(@PathVariable Long userId,@RequestBody Pet pet) {
        return petService.addPet(pet);
    }
	
	@PutMapping(path = "/{userId}/update/{petId}")
    public Long update(@PathVariable Long userId,@PathVariable Long petId,@RequestBody Pet pet) {
		
        return petService.addPet(pet);
    }
	
	@DeleteMapping(path="/delete/{petId}")
	public void delete(@PathVariable Long petId) {
		petService.delete(petId);
	}
}
