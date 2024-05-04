package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Patient;
import com.example.cabinet.Repositories.PatientRepository;
import com.example.cabinet.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }


    @Override
    public boolean addPatient(Patient patient) {
        try {
            patientRepository.save(patient);
            return true;
        } catch (Exception e) {
            logger.error("An error occurred while adding a patient", e);
            return false;
        }
    }

    @Override
    public boolean updatePatient(Patient patient) {
        try {
            patientRepository.save(patient);
            return true;
        } catch (Exception e) {
            logger.error("An error occurred while updating a patient", e);
            return false;
        }
    }

    @Override
    public boolean deletePatient(Patient patient) {
        try {
            patientRepository.delete(patient);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
