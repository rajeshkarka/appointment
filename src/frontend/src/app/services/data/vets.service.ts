import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Vet } from 'src/app/models/app.vet';

@Injectable({
  providedIn: 'root'
})
export class VetsService {

  vet:Vet;
  userId:number;


  constructor(
	private http:HttpClient,
	private activatedRoute:ActivatedRoute
) { }

loadVets(){
	console.log("invoking Vet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.get<Vet[]>(`http://localhost:8080/api/v1/branches/`);
	
}
 saveVet(vet){
	console.log("invoking Vet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	//this.vet=new Vet(1,'newbranch','address',['rajesh']);
	return this.http.post(`http://localhost:8080/api/v1/branches/addbranch`,this.vet);
 }

updateVet(vet){
	console.log("invoking Vet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.put(`http://localhost:8080/api/v1/vets/branches/${vet.vetId}`,vet);
 }
deleteVet(vetId){
	console.log("invoking Vet service.");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.delete(`http://localhost:8080/api/v1/branches/${vetId}`);
 }

}
