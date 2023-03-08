package fr.cs.authentificationproject.dto;

import fr.cs.authentificationproject.entities.Adresse;
import fr.cs.authentificationproject.entities.Role;
import fr.cs.authentificationproject.entities.User;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {


    private Integer id;

    @NotNull(message = "Le prénom ne doit pas être vide")
    @NotEmpty(message = "Le prénom ne doit pas être vide")
    @NotBlank(message = "Le prénom ne doit pas être vide")
    private String firstName;

    @NotNull(message = "Le nom ne doit pas être vide")
    @NotEmpty(message = "Le nom ne doit pas être vide")
    @NotBlank(message = "Le nom ne doit pas être vide")
    private String lastName;

    @NotNull(message = "L'email ne doit pas être vide")
    @NotEmpty(message = "L'email ne doit pas être vide")
    @NotBlank(message = "L'email ne doit pas être vide")
    @Email(message = "L'email n'est pas conforme")
    private String email;


    @NotNull(message = "Le mot de passe ne doit pas être vide")
    @NotEmpty(message = "Le mot de passe ne doit pas être vide")
    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    @Size(min = 8, max = 16, message = "Le mot de passe doit être entre 8 et 16 caracteres")
    private String password;


    private Role roles;
    private List<Adresse> adresse;
    private Integer userId;


    public static UserDto fromEntity(User user) {
        // null check
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .roles(user.getRole())
                .adresse(user.getAdresse())
                .build();
    }

    public static User toEntity(UserDto user) {
        // null check
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRoles())
                .build();
    }


}
