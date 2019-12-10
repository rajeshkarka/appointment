import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from 'src/app/models/app.appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentsService {

  userId:number;

  constructor(
	private http:HttpClient,
	private activatedRoute:ActivatedRoute
	) { }

loadAppointments(){
	console.log("loading appointments");
	this.userId = this.activatedRoute.snapshot.params['id']; 
	return this.http.get<Appointment[]>(`http://localhost:8080/api/v1/appointments/`);
}
}

