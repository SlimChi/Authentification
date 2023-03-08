package fr.cs.authentificationproject.repositories;

import fr.cs.authentificationproject.entities.Adresse;
import fr.cs.authentificationproject.entities.TypeAdresse;
import fr.cs.authentificationproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {

}
