package com.example.cabinet.Controllers;

import com.example.cabinet.Models.Medication;
import com.example.cabinet.Services.Implementation.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mc")
@CrossOrigin("*")

public class MedicationController {

    @Autowired
    MedicationServiceImpl medicationService;

    @GetMapping("/gm")
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }
}
