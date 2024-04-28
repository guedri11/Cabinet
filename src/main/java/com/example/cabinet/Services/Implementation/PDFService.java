package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Ordonnance;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;

@Service
public class PDFService {

 public byte[] generatePrescriptionPdf(Ordonnance data){
     ByteArrayOutputStream out = new ByteArrayOutputStream();
     PdfWriter writer = new PdfWriter(out);
     PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Prescription ID"));
        document.add(new Paragraph(data.getPrescriptionId()));
        document.add(new Paragraph("Patient ID"));
        document.add(new Paragraph(data.getPatientId()));
        document.add(new Paragraph("Patient Name"));
        document.add(new Paragraph(data.getPatientName()));
        document.add(new Paragraph("Patient Age"));
        document.add(new Paragraph(String.valueOf(data.getPatientAge())));
        document.add(new Paragraph(data.getDoctorName()));
        document.add(new Paragraph(data.getDoctorSpecialization()));
        document.add(new Paragraph(data.getDateIssued()));
        document.add(new Paragraph(data.getPharmacyNotes()));
        document.close();
        return out.toByteArray();
 }

}
