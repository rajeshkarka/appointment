package com.intuit.demo.boot.appointment.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name="appointments")
public class Appointment {

	@Id 
	@GeneratedValue 
	@Column(name="appointment_id")
    private Long id;
	
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    
    @Column(name="date")
    private LocalDate appointmentDate;
    
    @Column(name="start_time")
    private Timestamp appointmentStartTime;
    
    @Column(name="end_time")
    private Timestamp appointmentEndTime;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="doctor_name")
    private Doctors doctor;
    
    @Column(name="status")
    private Long statusId;
    
    @Column(name="price")
    private BigDecimal price;
    
    @Column(name="pet_id")
    private Long petId;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="branch_id")
    private Veterinary veterinary;

    public Appointment() {

    }

   
    public Appointment(Long id, Timestamp createdAt, LocalDate appointmentDate, Timestamp appointmentStartTime,
    		Timestamp appointmentEndTime, Doctors nameOfDoctor, Long status, BigDecimal price, Long petId,
			Veterinary veterinary) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.appointmentDate = appointmentDate;
		this.appointmentStartTime = appointmentStartTime;
		this.appointmentEndTime = appointmentEndTime;
		this.doctor = nameOfDoctor;
		this.statusId = status;
		this.price = price;
		this.petId = petId;
		this.veterinary = veterinary;
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

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Timestamp getAppointmentStartTime() {
		return appointmentStartTime;
	}


	public void setAppointmentStartTime(Timestamp appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}


	public Timestamp getAppointmentEndTime() {
		return appointmentEndTime;
	}


	public void setAppointmentEndTime(Timestamp appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}


	public Doctors getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}


	

    public Long getStatusId() {
		return statusId;
	}


	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}


	public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
