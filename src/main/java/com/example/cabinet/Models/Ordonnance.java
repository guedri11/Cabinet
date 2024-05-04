package com.example.cabinet.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ordonnance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ordonnance {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int prescriptionId;
 private int patientId;
 private int patientAge;
 private String patientGender;
 private String patientName;
 private String doctorName;
 private String doctorSpecialization;
 private String dateIssued;
 //  @OneToMany(mappedBy = "ordonnance",cascade = CascadeType.ALL,orphanRemoval = true)
 //  List<Medication> medications = new ArrayList<>();
 private String pharmacyNotes;
}
