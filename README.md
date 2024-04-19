DoctorAppointment
Doctor Appointment is a Spring Web REST API project designed to facilitate appointment booking with doctors. It provides endpoints for managing doctors and booking appointments.

Features:
Doctor Management: Allows users to retrieve a list of all doctors or fetch details of a specific doctor by ID.
Appointment Booking: Enables users to book appointments with doctors by providing patient details, appointment date, and time.
Validation: Validates input data to ensure that required fields are provided and appointment dates are in the future.
Technologies Used:
Java 17
Spring Boot 3.2.4
Spring Data JPA
Spring Web
Spring Boot Validation
MySQL Connector
Maven
How to Run:
Clone the repository to your local machine.
Configure MySQL database settings in application.properties.
Build the project using Maven: mvn clean install.
Run the application: java -jar target/DoctorAppointment-0.0.1-SNAPSHOT.jar.
API Endpoints:
GET /doctors: Retrieve a list of all doctors.
GET /doctors/{id}: Retrieve details of a specific doctor by ID.
POST /doctors/{doctor}/appointments: Book an appointment with a specific doctor.
Author:
Laxman Angadala
