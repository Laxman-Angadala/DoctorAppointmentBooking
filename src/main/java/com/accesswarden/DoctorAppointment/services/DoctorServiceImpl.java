package com.accesswarden.DoctorAppointment.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesswarden.DoctorAppointment.Appointment;
import com.accesswarden.DoctorAppointment.Doctor;
import com.accesswarden.DoctorAppointment.repository.AppointmentRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public boolean isSlotAvailable(Doctor doctor, Date date, String time) {
        // Fetch existing appointments for the doctor on the requested date
        List<Appointment> appointments = appointmentRepository.findByDoctorAndDate(doctor, date);

        // Check if any appointment overlaps with the requested time slot
        for (Appointment appointment : appointments) {
            if (isTimeSlotOverlapping(appointment.getTime(), time)) {
                return false; // Slot already booked or unavailable
            }
        }

        // Slot is available if no conflicts found
        return true;
    }

    private boolean isTimeSlotOverlapping(String existingTime, String requestedTime) {
        // Implement logic to check if time slots overlap (consider time format)
        // This example assumes a simple time format (e.g., "HH:MM")
        String[] existingTimeParts = existingTime.split(":");
        String[] requestedTimeParts = requestedTime.split(":");

        int existingHour = Integer.parseInt(existingTimeParts[0]);
        int existingMinute = Integer.parseInt(existingTimeParts[1]);
        int requestedHour = Integer.parseInt(requestedTimeParts[0]);
        int requestedMinute = Integer.parseInt(requestedTimeParts[1]);

        // Check for same time slot or conflicting time ranges
        if ((existingHour == requestedHour && existingMinute == requestedMinute) ||
                (existingHour == requestedHour && Math.abs(existingMinute - requestedMinute) < DURATION_OF_APPOINTMENT_MINUTES)) {
            return true;
        }

        return false;
    }

    private static final int DURATION_OF_APPOINTMENT_MINUTES = 30; // Replace with actual appointment duration
}
