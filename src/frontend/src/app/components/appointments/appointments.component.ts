import { Component, OnInit } from '@angular/core';
import { AppointmentsService } from 'src/app/services/data/appointments.service';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  constructor(private appointmentService:AppointmentsService) { }

  ngOnInit() {
	this.loadAppointments();
  }

  loadAppointments(){
	this.appointmentService.loadAppointments();
}
}
