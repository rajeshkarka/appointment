import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(
) { }

loadPets(){
	console.log("invoking pet service.");
	//return this.http.get('http://localhost:8080/api/v1/pets/1');
	
}
}
