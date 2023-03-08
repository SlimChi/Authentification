package fr.cs.authentificationproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

/**
 * @author
 * @Project
 */


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse  {

    @Id
    @GeneratedValue
    private Integer id;
    private String rue;

    private String complement;

    private String codePostal;

    private String ville;

        @ManyToOne
        @JoinColumn(name = "id_type_adresse")
        private TypeAdresse typeAdresse;

    //    @ManyToOne()
//    @JoinColumn(name = "id_user")
//    private User user;
    @Basic
    @Column(name = "id_user")
    private int user;

}
