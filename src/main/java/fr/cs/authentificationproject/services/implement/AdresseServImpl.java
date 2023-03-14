package fr.cs.authentificationproject.services.implement;

import fr.cs.authentificationproject.dto.AdresseDto;
import fr.cs.authentificationproject.dto.AdresseResponse;
import fr.cs.authentificationproject.entities.Adresse;
import fr.cs.authentificationproject.repositories.AdresseRepository;
import fr.cs.authentificationproject.repositories.UserRepository;
import fr.cs.authentificationproject.services.AdresseService;
import fr.cs.authentificationproject.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author slimane
 * @Project auth
 */
@Service
@RequiredArgsConstructor
public class AdresseServImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private ObjectsValidator<AdresseDto> validator;
    private final UserRepository userRepository;


    @Override
   public Integer save(AdresseDto dto) {
        Adresse address = AdresseDto.toEntity(dto);
    return adresseRepository.save(address).getId();
    }

    @Override
    @Transactional
    public void addAdresseToUser(AdresseDto dto){

        Adresse adresse = AdresseDto.toEntity(dto);

        adresseRepository.save(adresse).getUser();
    }

    @Override
    public Integer save(AdresseResponse dto) {
        return null;
    }

    @Override
    public List<AdresseResponse> findAll() {
        return adresseRepository.findAll()
                .stream()
                .map(AdresseResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdresseResponse findById(Integer id) {
        return adresseRepository.findById(id)
                .map(AdresseResponse::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
    }

    @Override
    @Transactional
    public void updateAdress(Integer id, String rue, String complement, String codePostal, String ville){

        Adresse updateAdresse = adresseRepository.findById(id).orElseThrow();

        updateAdresse.setId(id);
        updateAdresse.setRue(rue);
        updateAdresse.setComplement(complement);
        updateAdresse.setCodePostal(codePostal);
        updateAdresse.setVille(ville);

    }



    @Override
    public void delete(Integer id) {
        // todo check delete
        adresseRepository.deleteById(id);
    }

}
