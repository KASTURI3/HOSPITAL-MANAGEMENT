package com.Hospital.Management.System.doclogin.repository;

import com.Hospital.Management.System.doclogin.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
