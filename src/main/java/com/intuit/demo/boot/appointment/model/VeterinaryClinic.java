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
public class VeterinaryClinic {

	@Id @GeneratedValue
	@Column(name="id")
	private Long branchId;
	
	@Column(name="branch_name")
	private String brnachName;
	
	@Column(name="address")
	private String address;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Doctors> doctors;
}
