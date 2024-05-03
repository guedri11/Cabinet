package com.example.cabinet.Repositories;

import com.example.cabinet.Models.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonnanceRepository  extends JpaRepository<Ordonnance,String> {
}
