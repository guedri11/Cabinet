package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Patient;
import com.example.cabinet.Repositories.PatientRepository;
import com.example.cabinet.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository PatientRepository;
    @Override
    public List<Patient> getAllPatients() {
        return PatientRepository.findAll();
    }

    @Override
    public boolean addPatient(Patient patient) {
       try {
           PatientRepository.save(patient);
           return true;
       }catch (Exception se){
           return false;
       }
    }
}
