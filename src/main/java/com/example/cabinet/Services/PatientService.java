package com.example.cabinet.Services;

import com.example.cabinet.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
     List<Patient> getAllPatients();
     Patient getPatientById(int id);
     boolean addPatient(Patient patient);
     boolean updatePatient(Patient patient);
     boolean deletePatient(Patient patient);

}
