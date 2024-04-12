package com.example.cabinet.Controllers;

import com.example.cabinet.Models.Patient;
import com.example.cabinet.Services.Implementation.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pc")
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    @PostMapping("/add_patient")
    public boolean addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
    @GetMapping("/getPatients")
    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }
}
