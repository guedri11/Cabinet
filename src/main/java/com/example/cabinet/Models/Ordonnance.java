package com.example.cabinet.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cabinet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ordonnance {
 @Id
    String prescriptionId ;
  String patientId ;
  int patientAge ;
  String patientGender ;
  String patientName ;
  String doctorName ;
  String doctorSpecialization ;
  String dateIssued ;
  @OneToMany(mappedBy = "ordonnance",cascade = CascadeType.ALL,orphanRemoval = true)
  List<Medication> medications = new ArrayList<>();
  String pharmacyNotes ;

}
