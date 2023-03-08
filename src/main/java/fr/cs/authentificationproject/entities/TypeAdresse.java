package fr.cs.authentificationproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
@Table(name = "type_adresse")
public class TypeAdresse{

    @Id
    @GeneratedValue
    private Integer id;
    private String libelle;



}
