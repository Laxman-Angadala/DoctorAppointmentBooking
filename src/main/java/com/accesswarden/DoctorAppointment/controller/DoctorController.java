package com.accesswarden.DoctorAppointment.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesswarden.DoctorAppointment.Appointment;
import com.accesswarden.DoctorAppointment.Doctor;
import com.accesswarden.DoctorAppointment.model.AppointmentRequest;
import com.accesswarden.DoctorAppointment.repository.AppointmentRepository;
import com.accesswarden.DoctorAppointment.repository.DoctorRepository;
import com.accesswarden.DoctorAppointment.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@GetMapping
	public java.util.List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable Long id) {
		return doctorRepository.findById(id);
	}


	public DoctorRepository getDoctorRepository() {
		return doctorRepository;
	}

	public void setDoctorRepository(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public AppointmentRepository getAppointmentRepository() {
		return appointmentRepository;
	}

	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Autowired
	private DoctorService doctorService;  // Injected by Spring Boot
	
	@PostMapping("/{doctor}/appointments")
	public ResponseEntity<Object> bookAppointment(@PathVariable Doctor doctor, @Valid @RequestBody AppointmentRequest request) {
		 
		// Validate the request using @Valid annotation
		if (!doctorService.isSlotAvailable(doctor, request.getDate(), request.getTime())) {
			return ResponseEntity.badRequest().body("Slot is unavailable for the doctor at the requested time.");
		}

		Appointment appointment = new Appointment();
		appointment.setDoctor(doctor);
		appointment.setPatientName(request.getPatientName());
		appointment.setDate(request.getDate());
		appointment.setTime(request.getTime());

		appointmentRepository.save(appointment);
		return ResponseEntity.ok("Appointment booked successfully!");
//        }
	}

}
