package com.example.repositories;

import com.example.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenceRepository extends JpaRepository<Agence, Long>{
    /*En Java, Optional n'est pas spécifique à Spring, mais c'est une classe introduite dans Java 8 pour gérer les valeurs pouvant être nulles. Cette classe est utilisée pour éviter les erreurs dues aux références nulles.
    En relation avec Spring, Optional est souvent utilisé pour les retours de méthodes dans les services ou les repositories. Par exemple, les méthodes de recherche dans un repository Spring Data peuvent renvoyer un Optional pour indiquer qu'elles peuvent potentiellement renvoyer une valeur nulle.*/

    Optional<Agence> findByLoginAndPassword(String login, String password);

}
