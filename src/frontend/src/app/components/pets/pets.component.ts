import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/services/data/pet-service';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  constructor(private petsService:PetService) { }

  ngOnInit() {
	this.loadPets;
  }

loadPets(){
	this.petsService.loadPets();
	console.log("loading pets");
}
}

export class Pet{
	constructor(
		public id:number,
		public name:string,
		public description:string,
		public age:number,
		public gender:string
	){}
}
