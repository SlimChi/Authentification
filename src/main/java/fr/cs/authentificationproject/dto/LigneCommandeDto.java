package fr.cs.authentificationproject.dto;

import fr.cs.authentificationproject.entities.LigneCommandes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author slimane
 * @Project myPrint
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class LigneCommandeDto {

    private Integer idLigneCommande;

    private boolean rectoVerso;

    private boolean couleur;

    private Integer nbrExemplaires;

    private Integer nbrFeuilles;

    private String fichier;


    public static LigneCommandeDto fromEntity(LigneCommandes ligneCommandes) {
        return LigneCommandeDto.builder()
                .idLigneCommande(ligneCommandes.getIdLigneCommande())
                .rectoVerso(ligneCommandes.isRectoVerso())
                .couleur(ligneCommandes.isCouleur())
                .nbrExemplaires(ligneCommandes.getNbrExemplaires())
                .nbrFeuilles(ligneCommandes.getNbrFeuilles())
                .build();
    }

    public static LigneCommandes toEntity(LigneCommandeDto ligneCommande) {
        return LigneCommandes.builder()
                .idLigneCommande(ligneCommande.getIdLigneCommande())
                .rectoVerso((ligneCommande.isRectoVerso()))
                .couleur(ligneCommande.isCouleur())
                .nbrExemplaires(ligneCommande.getNbrExemplaires())
                .nbrFeuilles(ligneCommande.getNbrFeuilles())
                .build();
    }
}
