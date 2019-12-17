package com.intuit.demo.boot.appointment.controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.boot.appointment.dto.AppointmentDTO;
import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.model.AppointmentStatus;
import com.intuit.demo.boot.appointment.model.EventDto;
import com.intuit.demo.boot.appointment.repository.DoctorsRepository;
import com.intuit.demo.boot.appointment.service.AppointmentService;
import com.intuit.demo.boot.status.service.AppointmentStatusService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentStatusService appointmentStatustService;
	
	@Autowired
	private DoctorsRepository doctorsRepository;
	
	
	@RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
	@ResponseBody
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }
	
	@RequestMapping(path = "/{start}/{end}", method = RequestMethod.GET)
    List<EventDto> appointmentsByDate(@PathVariable String start,@PathVariable String end) {
		List<Appointment> appointments=appointmentService.findAll();
		List<EventDto> events=new ArrayList<EventDto>();
		for(Appointment appointment:appointments) {
			EventDto event=createEventDto(appointment);
			events.add(event);
		}
        return events;
    }
	
	
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
    EventDto create(@RequestBody AppointmentDTO appointmentDto) {
		try {
			String startTime = appointmentDto.getAppointmentStartTime();
			String endTime = appointmentDto.getAppointmentEndTime();
			if (appointmentService.isAvailable(appointmentDto.getPetId(), appointmentDto.getVeterinary().getBranchId(),
					startTime, endTime)) {
				Appointment appointment = new Appointment();
				appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				Date date = formate.parse(appointmentDto.getAppointmentStartTime().replace("T", " "));

				appointment.setAppointmentStartTime(new Timestamp(date.getTime()));
				Date endDate = formate.parse(appointmentDto.getAppointmentEndTime().replace("T", " "));

				appointment.setAppointmentEndTime(new Timestamp(endDate.getTime()));
				appointment.setDoctor(doctorsRepository.getOne(appointmentDto.getDoctorId()));
				appointment.setPetId(appointmentDto.getPetId());
				appointment.setVeterinary(appointmentDto.getVeterinary());

				AppointmentStatus status = new AppointmentStatus();
				status.setUserId(appointmentDto.getUserId());
				status.setAppointmentId(appointment.getId());
				status = appointmentStatustService.schedule(status);
				appointment.setStatusId(status.getScheduleId());

				appointment = appointmentService.create(appointment);
				return createEventDto(appointment);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	private EventDto createEventDto(Appointment appointment) {
		EventDto event=new EventDto();
		event.setId(appointment.getId());
		event.setStart(appointment.getAppointmentStartTime().toString().replace(" ", "T"));
		event.setEnd(appointment.getAppointmentEndTime().toString().replace(" ", "T"));
		event.setText("");
		return event;
	}
	
}
