package com.example.cabinet.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Medication")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medication {
    @Id
    String medicineName;
    String dosage;
    String frequency;
    int Duration;
    String route;
    String instructions;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "prescriptionId" , insertable = false, updatable = false)

}
