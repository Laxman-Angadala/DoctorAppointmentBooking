package com.accesswarden.DoctorAppointment.services;

import java.util.Date;

import com.accesswarden.DoctorAppointment.Doctor;

public interface DoctorService {

	boolean isSlotAvailable(Doctor doctor, Date date, String time);
}
