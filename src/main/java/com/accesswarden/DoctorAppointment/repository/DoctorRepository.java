package com.accesswarden.DoctorAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesswarden.DoctorAppointment.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	
}
