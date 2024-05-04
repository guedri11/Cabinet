package com.example.cabinet.Services;


import com.example.cabinet.Models.Ordonnance;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrdonnanceService {
    byte[] generatePrescriptionPdf(String data);
    boolean addOrdonnance(Ordonnance ordonnance);
    List<Ordonnance> getOrdonnance();
    Ordonnance getOrdonnanceById(String id);
    boolean updateOrdonnance(Ordonnance ordonnance);
    boolean deleteOrdonnance(String id);

}

