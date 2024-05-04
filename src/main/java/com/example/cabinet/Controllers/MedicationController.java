package com.example.cabinet.Controllers;

import com.example.cabinet.Models.Medication;
import com.example.cabinet.Services.Implementation.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add_med")
    public boolean addMedication(@RequestBody Medication medication) {
        return medicationService.addMedication(medication);
    }

    @PutMapping("/update_med")
    public boolean updateMedication(@RequestBody Medication medication) {
        return medicationService.updateMedication(medication);
    }

    @DeleteMapping("/delete_med")
    public boolean deleteMedication(@RequestParam(name = "id") String id) {
        return medicationService.deleteMedication(id);
    }
}
