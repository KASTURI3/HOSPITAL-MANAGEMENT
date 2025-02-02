package com.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "drug_name")
    private String drugName;

    private String stock;

    // Constructor with parameters
    public Medicine(long id, String drugName, String stock) {
        super();
        this.id = id;
        this.drugName = drugName;
        this.stock = stock;
    }

    // Default constructor
    public Medicine() {
        super();
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
