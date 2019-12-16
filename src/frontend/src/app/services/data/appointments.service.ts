import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from 'src/app/models/app.appointment';
import { DayPilot } from 'daypilot-pro-angular';
import { Observable } from 'rxjs';

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

getEvents(start: DayPilot.Date, end: DayPilot.Date): Observable<Appointment[]> {
    return this.http.post("http://localhost:8080/api/v1/appointments/", {start: start, end: end}) as Observable<Appointment[]>;
  }
createEvent(params){
	return this.http.post("http://localhost:8080/api/v1/appointments/", {start: params.start, end: params.end}) as Observable<Appointment[]>;

}

}

