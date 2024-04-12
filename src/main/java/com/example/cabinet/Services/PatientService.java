package com.example.cabinet.Services;

import com.example.cabinet.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    public List<Patient> getAllPatients();
    public boolean addPatient(Patient patient);


}
