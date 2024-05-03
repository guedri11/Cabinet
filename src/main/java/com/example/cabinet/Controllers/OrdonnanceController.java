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
    @GetMapping(value = "/gpdf",produces = "application/pdf")
    public byte[] generatePdf(@RequestParam(name = "data") String data) throws MessagingException {
          //check if the ordonnaceIsFound
         Ordonnance OC = ordonnanceService.getOrdonnanceById(data);
          if(OC != null){
                return pdfService.generatePrescriptionPdf(OC);
          }else{
                return null;
          }

    }
    @GetMapping("/getOrdonnances")
    public List<Ordonnance> getOrdonnances(){
        return ordonnanceService.getOrdonnance();
    }
    @PostMapping("/add_ordonnance")
    public boolean addOrdonnance(@RequestBody Ordonnance ordonnance){
        return ordonnanceService.addOrdonnance(ordonnance);
    }
}
