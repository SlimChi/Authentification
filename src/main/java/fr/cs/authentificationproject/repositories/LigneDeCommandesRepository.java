package fr.cs.authentificationproject.repositories;

import fr.cs.authentificationproject.entities.LigneCommandes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneDeCommandesRepository extends JpaRepository<LigneCommandes, Integer> {

}