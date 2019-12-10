import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Pet } from 'src/app/models/app.pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  userId="";
  pet:Pet;

  constructor(
	private http:HttpClient,
	private activatedRoute:ActivatedRoute
) { }

loadPets(){
	console.log("invoking pet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.get<Pet[]>(`http://localhost:8080/api/v1/pets/my/1`);
	
}
 savePet(pet){
	console.log("invoking pet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	//pet=new Pet(1,1,'raju','nodescription',4,'newbreed','male');
	return this.http.post(`http://localhost:8080/api/v1/pets/1/add`,pet);
 }

updatePet(pet){
	console.log("invoking pet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.put(`http://localhost:8080/api/v1/pets/1/update/${pet.petId}`,pet);
 }
deletePet(petId){
	console.log("invoking pet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.delete(`http://localhost:8080/api/v1/pets/delete/${petId}`);
 }

}
