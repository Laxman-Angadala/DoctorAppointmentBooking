package com.accesswarden.DoctorAppointment.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AppointmentRequest {

    @NotBlank(message = "Patient name is required")
    private String patientName;

    @NotNull(message = "Date is required")
    @Future(message = "Appointment date must be in the future")
    private Date date;

    @NotBlank(message = "Time is required")
    private String time;

    // Getters and Setters

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}