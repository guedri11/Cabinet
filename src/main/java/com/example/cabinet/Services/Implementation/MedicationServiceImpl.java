package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Medication;
import com.example.cabinet.Repositories.MedicationRepository;
import com.example.cabinet.Services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl  implements MedicationService {

    @Autowired
    MedicationRepository medicationRepository ;

    @Override
    public boolean addMedication(Medication medication) {
        try {
            medicationRepository.save(medication);
            return true;

        }catch (Exception e){
            e.printStackTrace();

        }
        return  false ;
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication getMedicationByName(String name) {
        return null;
    }
}
