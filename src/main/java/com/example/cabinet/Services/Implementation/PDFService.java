package com.example.cabinet.Services.Implementation;

import com.example.cabinet.Models.Ordonnance;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

@Service
public class PDFService {

    public byte[] generatePrescriptionPdf(Ordonnance data) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Add a styled title
        Paragraph title = new Paragraph("Prescription Details")
                .setBold()
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(title);

        // Create a list for the details
        List list = new List();
        list.setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFontSize(12);

        // Add items to the list
        list.add(new ListItem("Prescription ID: " + data.getPrescriptionId()))
                .add(new ListItem("Patient ID: " + data.getPatientId()))
                .add(new ListItem("Patient Name: " + data.getPatientName()))
                .add(new ListItem("Patient Age: " + String.valueOf(data.getPatientAge())))
                .add(new ListItem("Doctor Name: " + data.getDoctorName()))
                .add(new ListItem("Doctor Specialization: " + data.getDoctorSpecialization()))
                .add(new ListItem("Date Issued: " + data.getDateIssued()))
                .add(new ListItem("Pharmacy Notes: " + data.getPharmacyNotes()));

        // Add the list to the document
        document.add(list);

        // Close the document
        document.close();

        return out.toByteArray();
    }
}