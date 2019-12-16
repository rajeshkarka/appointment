package com.intuit.demo.boot.appointment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctors")
public class Doctors {
	
	@Id
	@GeneratedValue
	@Column(name="doctor_id")
	private Long doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="speciality")
	private String speciality;
	
	@Column(name="hours")
	private String hours;

	public Doctors() {
		
	}
	public Doctors(Long doctorId, String doctorName, String speciality, String hours) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.hours = hours;
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
