package fr.cs.authentificationproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author slimane
 * @Project myPrint
 */

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandes {
    @Id
    @GeneratedValue
    private Integer idLigneCommande;

    private boolean rectoVerso;

    private boolean couleur;

    private Integer nbrExemplaires;

    private Integer nbrFeuilles;

    private String fichier;

}
