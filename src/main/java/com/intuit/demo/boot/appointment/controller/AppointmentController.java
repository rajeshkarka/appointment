package com.intuit.demo.boot.appointment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.service.AppointmentService;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
	@ResponseBody
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }
}
