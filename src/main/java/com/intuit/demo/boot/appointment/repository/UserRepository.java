package com.intuit.demo.boot.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.demo.boot.appointment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
