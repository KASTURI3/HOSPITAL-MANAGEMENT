package com.Hospital.Management.System.doclogin.controller;


import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import com.Hospital.Management.System.entity.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @GetMapping
    public List<Medicine> getAllPatients() {
        return medicineRepository.findAll();
    }
}
