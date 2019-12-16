package com.intuit.demo.boot.appointment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="veterinary")
public class Veterinary {

	@Id @GeneratedValue
	@Column(name="branch_id")
	private Long branchId;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="address")
	private String address;
	
	@OneToMany
	@JoinColumn(name="doctor_id")
	private List<Doctors> doctors;

	public Veterinary() {
		
	}
	public Long getBranchId() {
		return branchId;
	}

	public Veterinary(Long branchId, String branchName, String address, List<Doctors> doctors) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
		this.doctors = doctors;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
}
