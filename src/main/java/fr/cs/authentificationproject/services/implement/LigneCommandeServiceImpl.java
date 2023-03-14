package fr.cs.authentificationproject.services.implement;

import fr.cs.authentificationproject.dto.LigneCommandeDto;
import fr.cs.authentificationproject.entities.LigneCommandes;
import fr.cs.authentificationproject.repositories.LigneDeCommandesRepository;
import fr.cs.authentificationproject.services.LigneCommandeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author slimane
 * @Project myPrint
 */

@Service
@RequiredArgsConstructor
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneDeCommandesRepository ligneDeCommandesRepository;

//
//
//    @Override
//    public List<LigneCommandes> getCommande() {
//
//        return ligneDeCommandesRepository.findAll();
//
//    }
//
//    @Override
//    public Optional<LigneCommandes> getCommandeById(Integer id) {
//
//        return ligneDeCommandesRepository.findById(id);
//
//    }
//
//
//    @Transactional
//    @Override
//    public void addLigneCommande(LigneCommandes ligneCommandes) {
//
//        ligneDeCommandesRepository.save(ligneCommandes);
//    }


    @Transactional
    @Override
    public void modifyCommandes(Integer id,Boolean rectoVerso, Boolean couleur, Integer nbrExemplaires,Integer nbrFeuilles) {

        LigneCommandes oldCommandes = ligneDeCommandesRepository.findById(id).orElseThrow();

        oldCommandes.setIdLigneCommande(id);
        oldCommandes.setRectoVerso(rectoVerso);
        oldCommandes.setCouleur(couleur);
        oldCommandes.setNbrExemplaires(nbrExemplaires);
        oldCommandes.setNbrFeuilles(nbrFeuilles);


    }


    @Override
    @Transactional
    public Integer save(LigneCommandeDto dto) {
        LigneCommandes ligneCommandes = LigneCommandeDto.toEntity(dto);
        return ligneDeCommandesRepository.save(ligneCommandes).getIdLigneCommande();
    }

    @Override
    public List findAll() {
        return ligneDeCommandesRepository.findAll()
                .stream()
                .map(LigneCommandeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public LigneCommandeDto findById(Integer id) {
        return ligneDeCommandesRepository.findById(id)
                .map(LigneCommandeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        ligneDeCommandesRepository.deleteById(id);
    }
}
