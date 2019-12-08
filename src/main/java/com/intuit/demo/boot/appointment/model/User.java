package com.intuit.demo.boot.appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id @GeneratedValue
	private Long userId;
	private String userName;
	private String address;
	
}
