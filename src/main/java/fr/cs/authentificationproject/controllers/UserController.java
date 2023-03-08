package fr.cs.authentificationproject.controllers;

import fr.cs.authentificationproject.auth.AuthenticationResponse;
import fr.cs.authentificationproject.dto.AdresseDto;
import fr.cs.authentificationproject.dto.UserDto;
import fr.cs.authentificationproject.entities.Adresse;
import fr.cs.authentificationproject.services.AdresseService;
import fr.cs.authentificationproject.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User")
public class UserController {


    private final UserService userService;
    private final AdresseService adresseService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(
            @PathVariable("user-id") Integer userId
    ) {
        return ResponseEntity.ok(userService.findById(userId));
    }


    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathParam("id")Integer id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String email,
                                     @RequestParam String password){

        userService.updateUser(id,firstName,lastName,email,password);

        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("user-id") Integer userId
    ) {
        userService.delete(userId);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/{id}/adresses/add")
    public ResponseEntity addAdresseForUser(@PathParam("id") Integer id, @RequestBody AdresseDto adresse) {

        adresseService.addAdresseToUser(id, adresse);
        return ResponseEntity.ok().build();

    }


}
