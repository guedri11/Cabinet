package com.example.cabinet.Controllers;

import com.example.cabinet.Models.Ordonnance;
import com.example.cabinet.Services.Implementation.OrdonnanceServiceImpl;
import com.example.cabinet.Services.Implementation.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/oc")
public class OrdonnanceController {
    private final PDFService pdfService;

    @Autowired
    private OrdonnanceServiceImpl ordonnanceService;

    public OrdonnanceController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping(value = "/gpdf", produces = "application/pdf")
    public byte[] generatePdf(@RequestParam(name = "data") String data) throws MessagingException {
        // Check if the ordonnance is found
        Ordonnance ordonnance = ordonnanceService.getOrdonnanceById(data);
        if (ordonnance != null) {
            return pdfService.generatePrescriptionPdf(ordonnance);
        } else {
            return null;
        }
    }

    @GetMapping("/getOrdonnances")
    public List<Ordonnance> getOrdonnances() {
        return ordonnanceService.getOrdonnance();
    }

    @PostMapping("/add_ordonnance")
    public boolean addOrdonnance(@RequestBody Ordonnance ordonnance) {
        return ordonnanceService.addOrdonnance(ordonnance);
    }

    @PutMapping("/update_ordonnance")
    public boolean updateOrdonnance(@RequestBody Ordonnance ordonnance) {
        return ordonnanceService.updateOrdonnance(ordonnance);
    }

    @DeleteMapping("/delete_ordonnance")
    public boolean deleteOrdonnance(@RequestParam(name = "id") String id) {
        return ordonnanceService.deleteOrdonnance(id);
    }
}
