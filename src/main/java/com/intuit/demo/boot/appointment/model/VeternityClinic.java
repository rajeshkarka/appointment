package com.intuit.demo.boot.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class VeternityClinic {

	@Id @GeneratedValue
	private Long branchId;
	private String brnachName;
	private String address;
}
