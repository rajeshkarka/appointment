package com.intuit.demo.boot.status.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.intuit.demo.boot.appointment.model.AppointmentStatus;
import com.intuit.demo.boot.appointment.repository.AppointmentStatusRepository;

@Component
@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService {

	@Autowired
	private AppointmentStatusRepository appointmentStatusRepository;

	public AppointmentStatusServiceImpl() {

	}

	public AppointmentStatusServiceImpl(AppointmentStatusRepository appointmentStatusRepository) {
		super();
		this.appointmentStatusRepository = appointmentStatusRepository;
	}

	@Override
	public AppointmentStatus schedule(AppointmentStatus appointmentStatus) {
		return appointmentStatusRepository.save(appointmentStatus);
	}

	@Override
	public AppointmentStatus cancelSchedule(AppointmentStatus appointmentStatus) {
		appointmentStatus.setStatus("cancelled");
		return appointmentStatusRepository.save(appointmentStatus);
	}

}
