package com.intuit.demo.boot.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.demo.boot.appointment.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}

