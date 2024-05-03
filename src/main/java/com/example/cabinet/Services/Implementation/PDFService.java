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
    public void sendEmailWithPdf( String toEmail, String subject) throws MessagingException {
        String fromEmail = "infogames.trtn@gmail.com"; // Modify with your email
        String username = "infogames.trtn@gmail.com";           // Modify with your SMTP username
        String password = "Freefallaga123";         // Modify with your SMTP password

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Specify the SMTP server
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);

        // Create a multipart message for attachment
        Multipart multipart = new MimeMultipart();

        // Create the message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Find attached the PDF.");

        // Part two is attachment
        MimeBodyPart attachmentPart = new MimeBodyPart();
       /* DataSource source = new ByteArrayDataSource(pdfContent, "application/pdf");
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName("prescription.pdf");
*/
        // Set text message part and attachment part
        multipart.addBodyPart(messageBodyPart);
       // multipart.addBodyPart(attachmentPart);

        // Send the complete message parts
        message.setContent(multipart);

        // Send message
        Transport.send(message);
        System.out.println("Email Sent with attachment successfully....");
    }
 public byte[] generatePrescriptionPdf(Ordonnance data) throws MessagingException {
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
       sendEmailWithPdf("mabrouki552@gmail.com","Prescription Details");
     return out.toByteArray();
 }

}
