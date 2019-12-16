package com.intuit.demo.boot.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.boot.appointment.model.Veterinary;
import com.intuit.demo.boot.veternity.service.VeterinaryService;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {

	@Autowired(required=false)
	@Qualifier("veterneryService")
	VeterinaryService veterneryService;

	public BranchController(VeterinaryService veternityService) {
		this.veterneryService = veternityService;
	}

	@GetMapping("/")
	public List<Veterinary> getClinics() {

		return veterneryService.getAllClinics();
	}

	@RequestMapping(name="/addbranch",method=RequestMethod.POST)
	public Veterinary saveBranch(@RequestBody Veterinary vet) {
		vet=veterneryService.addVeternity(vet);

		return vet;
	}

	@PutMapping("/update/{vetId}")
	public Veterinary updateVet(@PathVariable Long vetId, @RequestBody Veterinary vet) {

		Veterinary existingVet = veterneryService.getVeternity(vetId);
		existingVet = vet;
		veterneryService.addVeternity(existingVet);
		return existingVet;
	}

	@DeleteMapping("/{vetId}")
	public void deleteVet(@PathVariable Long vetId) {
		veterneryService.delete(vetId);
	}

}
