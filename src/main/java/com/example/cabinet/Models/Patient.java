package com.example.cabinet.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    private int id;
    @Column(name = "nom")
    private String nom ;
    private String prenom ;
    private String adresse ;
    private String email ;
    private String telephone ;
    private int age;



}
