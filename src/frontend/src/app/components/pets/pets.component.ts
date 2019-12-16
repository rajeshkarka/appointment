import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/services/data/pet-service';
import { Pet } from 'src/app/models/app.pet';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  constructor(private petsService:PetService,private router:Router) { }

 id:number;
 pets:Pet[];

  ngOnInit() {
	this.loadPets();
  }

loadPets(){
	console.log("loading pets");
	return this.petsService.loadPets().subscribe(
		response=>{
			this.pets =response,console.log(this.pets)}
	);
}

deletePet(petId){
	this.petsService.deletePet(petId).subscribe();
	this.router.navigate(['pets']);
}
}

