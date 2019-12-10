import { Component, OnInit } from '@angular/core';
import { AppointmentsService } from 'src/app/services/data/appointments.service';
import { Appointment } from 'src/app/models/app.appointment';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  appointments:Appointment[];

  constructor(private appointmentService:AppointmentsService) { }

  ngOnInit() {
	this.loadAppointments();
  }

  loadAppointments(){
	return this.appointmentService.loadAppointments().subscribe(
		response=>{
			this.appointments =response}
	);
}
}
