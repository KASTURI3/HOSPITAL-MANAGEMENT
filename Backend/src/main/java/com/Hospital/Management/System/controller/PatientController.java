package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class PatientController {

    private final PatientRepository patientRepository;

    // Constructor injection
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // POST method to insert patient data
    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients")
    public List<Patient>getAllPatients() {
        return patientRepository.findAll();
    }

    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) {
        patientRepository.findById(id);
    }
}
