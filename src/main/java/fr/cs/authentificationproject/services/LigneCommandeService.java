package fr.cs.authentificationproject.services;


import fr.cs.authentificationproject.dto.LigneCommandeDto;
import jakarta.transaction.Transactional;

/**
 * @author slimane
 * @Project myPrint
 */

public interface LigneCommandeService extends AbstractService<LigneCommandeDto> {


    @Transactional
    void modifyCommandes(Integer id, Boolean rectoVerso, Boolean couleur, Integer nbrExemplaires, Integer nbrFeuilles);
}
