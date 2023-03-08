package fr.cs.authentificationproject.services;

import fr.cs.authentificationproject.dto.AdresseDto;
import fr.cs.authentificationproject.entities.TypeAdresse;
import jakarta.transaction.Transactional;

/**
 * @author slimane
 * @Project auth
 */
public interface AdresseService extends AbstractService<AdresseDto>{

    @Transactional
    void addAdresseToUser(AdresseDto adresse);

    @Transactional
    void updateAdress(Integer id, String rue, String complement, String codePostal, String ville);


}
