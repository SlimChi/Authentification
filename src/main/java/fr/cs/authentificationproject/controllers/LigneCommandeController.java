package fr.cs.authentificationproject.controllers;

import fr.cs.authentificationproject.dto.AdresseDto;
import fr.cs.authentificationproject.dto.LigneCommandeDto;
import fr.cs.authentificationproject.entities.LigneCommandes;
import fr.cs.authentificationproject.repositories.LigneDeCommandesRepository;
import fr.cs.authentificationproject.services.AdresseService;
import fr.cs.authentificationproject.services.LigneCommandeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author slimane
 * @Project myPrint
 */

@RestController
@RequestMapping("/lignedDeCommandes")
@RequiredArgsConstructor
@Tag(name = "LignedDeCommandes")
public class LigneCommandeController {
    private final LigneCommandeService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody LigneCommandeDto ligneCommandeDto
    ) {
        return ResponseEntity.ok(service.save(ligneCommandeDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<LigneCommandeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{commande-id}")
    public ResponseEntity<LigneCommandeDto> findById(
            @PathVariable("commande-id") Integer ligneCommandeId
    ) {
        return ResponseEntity.ok(service.findById(ligneCommandeId));
    }

    @DeleteMapping("/{commande-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("commande-id") Integer ligneCommandeId
    ) {
        service.delete(ligneCommandeId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/update")
    public ResponseEntity updateCommande(@PathParam("id")Integer id,
                                       @RequestParam Boolean rectoVerso,
                                       @RequestParam Boolean couleur,
                                       @RequestParam Integer nbrExemplaires,
                                       @RequestParam Integer nbrFeuilles

    ){

        service.modifyCommandes(id,rectoVerso,couleur,nbrExemplaires,nbrFeuilles);

        return ResponseEntity.ok().build();

    }
}
