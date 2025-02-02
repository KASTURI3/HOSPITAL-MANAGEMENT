package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Create Appointment
    @PostMapping("/insert")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);  // 201 Created status
    }

    // Get All Appointments
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);  // 200 OK status
    }

    // Delete Appointment
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        if (appointment == null) {
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.FALSE);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);  // 404 Not Found
        }

        appointmentRepository.delete(appointment);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<>(response, HttpStatus.OK);  // 200 OK status
    }
}
