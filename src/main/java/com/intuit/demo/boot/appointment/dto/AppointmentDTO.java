package com.intuit.demo.boot.appointment.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.model.Doctors;
import com.intuit.demo.boot.appointment.model.User;
import com.intuit.demo.boot.appointment.model.Veterinary;

public class AppointmentDTO {

    private LocalDate appointmentDate;
    
    private String appointmentStartTime;
    private String appointmentEndTime;
    private Doctors doctor;
    private BigDecimal price;
    private Long petId;
    private Veterinary veterinary;
    
    private Long scheduleId;
	
	private User userId;
	
	private Appointment appointment;
    private String status;
	private Long doctorId;
	private String doctorName;
	private String speciality;
	private String hours;
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}
	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}
	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}
	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	public Veterinary getVeterinary() {
		return veterinary;
	}
	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	
	
	
	
}
