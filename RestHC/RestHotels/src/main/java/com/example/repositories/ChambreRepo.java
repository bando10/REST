package com.example.repositories;

import com.example.models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChambreRepo extends JpaRepository<Chambre, Long>{
    List<Chambre> findByNbPersonnesGreaterThanEqual(int nbPeoples);

}
