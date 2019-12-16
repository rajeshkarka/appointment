import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/services/data/pet-service';
import { Pet } from 'src/app/models/app.pet';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  pet:Pet;
  petForm:FormGroup;

  constructor(
	private petsService:PetService,
	private router:Router,
	private formBuilder:FormBuilder
	) { 
	}

  ngOnInit() {
	//this.pet=this.petsService.getPet(petId);
	this.pet=new Pet(1,1,'','',1,'','');
	
//this.pet=this.petForm.enable;
  }

  savePet(pet){
	this.petsService.savePet(this.pet).subscribe();
	this.router.navigate(["pets"]);
  }
}
