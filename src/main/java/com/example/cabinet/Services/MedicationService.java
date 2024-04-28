package com.example.cabinet.Services;

import com.example.cabinet.Models.Medication;

import java.util.List;

public interface MedicationService {
    boolean addMedication(Medication medication);
    List<Medication> getAllMedications();
    Medication getMedicationByName(String name);
}
