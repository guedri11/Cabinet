package com.example.cabinet.Controllers;

import com.example.cabinet.Services.Implementation.PDFService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/oc")
public class OrdonnanceController {
private final PDFService pdfService;

    public OrdonnanceController(PDFService pdfService) {
        this.pdfService = pdfService;
    }
    @GetMapping(value = "/gpdf",produces = "application/pdf")
    public byte[] generatePdf(@RequestParam(name = "data") String data){

        return pdfService.generatePrescriptionPdf();
    }
}
