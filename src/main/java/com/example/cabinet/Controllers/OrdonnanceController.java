package com.example.cabinet.Controllers;

import com.example.cabinet.Models.Ordonnance;
import com.example.cabinet.Services.Implementation.OrdonnanceServiceImpl;
import com.example.cabinet.Services.Implementation.PDFService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/oc")
public class OrdonnanceController {
private final PDFService pdfService;
private OrdonnanceServiceImpl ordonnanceService;
    public OrdonnanceController(PDFService pdfService) {
        this.pdfService = pdfService;
    }
    @GetMapping(value = "/gpdf",produces = "application/pdf")
    public byte[] generatePdf(@RequestParam(name = "data") String data){
          //check if the ordonnaceIsFound
         Ordonnance OC = ordonnanceService.getOrdonnanceById(data);
          if(OC != null){
                return pdfService.generatePrescriptionPdf(OC);
          }else{
                return null;
          }

    }
}
