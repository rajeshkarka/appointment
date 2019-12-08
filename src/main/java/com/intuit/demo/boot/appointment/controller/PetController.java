package com.intuit.demo.boot.appointment.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.boot.pet.service.PetService;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

	@Autowired(required=false)
	@Qualifier("petService")
	private PetService petService;
	
	
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@RequestMapping(path = "/{petId}", method = RequestMethod.GET)
    public Pet getById(@PathVariable Long petId) {
        return petService.getPet(petId);
    }
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
    public Long getById(@RequestBody HttpServlet requestBody) {
		Pet pet=new Pet();
		/*
		 * TODO add request processing and create Pet object.
		 */
        return petService.addPet(pet);
    }
}
