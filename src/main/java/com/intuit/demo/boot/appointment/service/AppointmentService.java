package com.intuit.demo.boot.appointment.service;


import java.util.List;
import java.util.Optional;

import com.intuit.demo.boot.appointment.model.Appointment;

public interface AppointmentService {
	
	List<Appointment> findByUserId(final Long userId);
	
	List<Appointment> findByPetId(final Long petId);

    Optional<Appointment> findById(Long appointmentId);

    List<Appointment> findAll();

    boolean isAvailable(final Long petId,final Long vetId,String startDate, String endDate);

    Appointment create(Appointment appointment);

    Appointment update(Long appointmentId, Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

    void deleteById(Long appointmentId);
    
}
