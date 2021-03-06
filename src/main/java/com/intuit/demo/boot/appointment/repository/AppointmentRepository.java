package com.intuit.demo.boot.appointment.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.model.Veterinary;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

   @Query("SELECT appointment FROM Appointment appointment WHERE appointment.petId = :petId AND appointment.veterinary=:veterinary AND appointment.appointmentStartTime=:appointmentStartTime AND appointment.appointmentEndTime=:appointmentEndTime")
   Appointment isAvailable(@Param("petId") Long petId,@Param("veterinary") Veterinary veterinary,@Param("appointmentStartTime") Date appointmentStartTime,@Param("appointmentEndTime") Date appointmentEndTime);

}
