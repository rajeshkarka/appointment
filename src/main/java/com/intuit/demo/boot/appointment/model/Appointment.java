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
	@Column(name="id")
    private Long id;
	
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    
    @Column(name="date")
    private LocalDate appointmentDate;
    
    @Column(name="start_time")
    private Time appointmentStartTime;
    
    @Column(name="end_time")
    private Time appointmentEndTime;
    
    @Column(name="doctor_name")
    private String nameOfDoctor;
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="status")
    private AppointmentStatus status;
    
    @Column(name="price")
    private BigDecimal price;
    
    @Column(name="pet_id")
    private Long petId;
    
    @Column(name="branch_id")
    private Long branchId;

    public Appointment() {

    }

    public Appointment(final Long petId,final Long branchId,final Timestamp createdAt,final LocalDate appointmentDate,final Time appointmentStartTime,final Time appointmentEndTime,final String nameOfDoctor,final AppointmentStatus status,final BigDecimal price) {
        this.petId=petId;
    	this.branchId=branchId;
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.nameOfDoctor = nameOfDoctor;
        this.status = status;
        this.price = price;
    }

    public Appointment(final Long petId,final Long branchId,LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String nameOfDoctor, BigDecimal price) {
    	this.petId=petId;
    	this.branchId=branchId;
    	this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.nameOfDoctor = nameOfDoctor;
        this.price = price;
    }

    public Appointment(final Long petId,final Long branchId,LocalDate appointmentDate, String nameOfDoctor, BigDecimal price) {
    	this.petId=petId;
    	this.branchId=branchId;
    	this.appointmentDate = appointmentDate;
        this.nameOfDoctor = nameOfDoctor;
        this.price = price;
    }

    
    public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
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

    public Time getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(Time appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public Time getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(Time appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
