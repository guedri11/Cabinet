package com.example.cabinet.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom ;
    private String prenom ;
    private String adresse ;
    @Column(name = "email",nullable = false)
    private String email ;
    @Column(unique = true,length = 8)
    private String telephone ;
    private int age;

}
