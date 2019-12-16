package com.intuit.demo.boot.status.service;

import com.intuit.demo.boot.appointment.model.AppointmentStatus;

public interface AppointmentStatusService {

	AppointmentStatus schedule(AppointmentStatus appointmentStatus);
	AppointmentStatus cancelSchedule(AppointmentStatus appointmentStatus);
	
}
