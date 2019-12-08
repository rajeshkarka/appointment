package com.intuit.demo.db;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intuit.demo.boot.appointment.model.Appointment;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);

}
