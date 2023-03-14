package fr.cs.authentificationproject.services;

import fr.cs.authentificationproject.dto.AdresseDto;
import fr.cs.authentificationproject.dto.AdresseResponse;
import jakarta.transaction.Transactional;

/**
 * @author slimane
 * @Project auth
 */
public interface AdresseService extends AbstractService<AdresseResponse>{


    Integer save(AdresseDto dto);

    @Transactional
    void addAdresseToUser(AdresseDto dto);

    @Transactional
    void updateAdress(Integer id, String rue, String complement, String codePostal, String ville);
}
