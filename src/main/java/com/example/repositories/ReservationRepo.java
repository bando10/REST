package com.example.repositories;

import com.example.models.Chambre;
import com.example.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Long>{

    @Query("SELECT c FROM Chambre c LEFT JOIN Reservation r ON c = r.chambre AND r.fin > ?1 AND r.deb < ?2 WHERE r.chambre IS NULL AND c.nbPersonnes >= ?3")
    List<Chambre> findByDebFinNbPersonnes(LocalDate deb, LocalDate fin, int nbPeoples);

}
