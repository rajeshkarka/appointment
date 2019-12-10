package com.intuit.demo.config;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.model.Pet;
import com.intuit.demo.boot.appointment.repository.AppointmentRepository;
import com.intuit.demo.boot.appointment.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner loadAppointments(AppointmentRepository appointmentRepository,PetRepository petRepository) {
        return args -> {
//            logger.info("Preloading " + appointmentRepository.save(new Appointment(new Long(1), new Long(1), LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"),"Markus", new BigDecimal(90))));
//            logger.info("Preloading " + appointmentRepository.save(new Appointment(new Long(2), new Long(2), LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  Time.valueOf("15:00:00"),"Thomas", new BigDecimal(60))));
//            logger.info("Preloading " + appointmentRepository.save(new Appointment(new Long(3), new Long(3), LocalDate.of(2019, 1, 10), Time.valueOf("08:00:00"),  Time.valueOf("09:00:00"),"Mikkel", new BigDecimal(30))));
//            logger.info("Preloading " + appointmentRepository.save(new Appointment(new Long(4), new Long(4), LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"),  Time.valueOf("19:00:00"),"Chris", new BigDecimal(10))));
//        
//        
//            logger.info("Preloading " + petRepository.save(new Pet(new Long(1), new Long(1),"sample description","Tommy", new Float("2.0"),"breed","male")));
//            logger.info("Preloading " + petRepository.save(new Pet(new Long(2), new Long(1),"sample description", "Ginni", new Float("2.0"),"breed","female")));
//            logger.info("Preloading " + petRepository.save(new Pet(new Long(3),new Long(1),"sample description",  "Ginni", new Float("2.0"),"breed","male")));
//            logger.info("Preloading " + petRepository.save(new Pet(new Long(4),new Long(1),"sample description", "Tommy", new Float("2.0"),"breed","female")));
//            
        };
    }    
    
}
