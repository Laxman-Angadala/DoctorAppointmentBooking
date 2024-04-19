package com.accesswarden.DoctorAppointment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesswarden.DoctorAppointment.Appointment;
import com.accesswarden.DoctorAppointment.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByDoctorAndDate(Doctor doctor, Date date);

}
