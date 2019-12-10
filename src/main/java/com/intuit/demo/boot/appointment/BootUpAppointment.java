package com.intuit.demo.boot.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.intuit.demo", "com.server.config"})
public class BootUpAppointment {

	public static void main(String[] args) {
		SpringApplication.run(BootUpAppointment.class, args);
	}

}
