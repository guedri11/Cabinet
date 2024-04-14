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
    private String nom ;
    private String prenom ;
    private String adresse ;
    @Column(unique = true,name = "email",nullable = false)
    private String email ;
    @Column(unique = true,length = 8)
    private String telephone ;
    private int age;



}
