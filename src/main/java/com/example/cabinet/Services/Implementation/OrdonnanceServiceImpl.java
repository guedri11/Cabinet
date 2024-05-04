package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Ordonnance;
import com.example.cabinet.Repositories.OrdonnanceRepository;
import com.example.cabinet.Services.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdonnanceServiceImpl implements OrdonnanceService {

@Autowired
OrdonnanceRepository ordonnanceRepository;

    @Override
    public byte[] generatePrescriptionPdf(String data) {
       return new byte[0];
    }

    @Override
    public boolean addOrdonnance(Ordonnance ordonnance) {
        try{
            ordonnanceRepository.save(ordonnance);

            return  true ;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Ordonnance> getOrdonnance() {
        return ordonnanceRepository.findAll();
    }

    @Override
    public Ordonnance getOrdonnanceById(String id) {
        return ordonnanceRepository.findById(id).get();
    }

    @Override
    public boolean updateOrdonnance(Ordonnance ordonnance) {
        try {
            ordonnanceRepository.save(ordonnance);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOrdonnance(String id) {
        try {
            ordonnanceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
