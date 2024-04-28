package com.example.cabinet.Services;

import com.example.cabinet.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
     List<Patient> getAllPatients();
     boolean addPatient(Patient patient);


}
