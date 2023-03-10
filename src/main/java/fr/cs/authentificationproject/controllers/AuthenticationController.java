package fr.cs.authentificationproject.controllers;


import fr.cs.authentificationproject.auth.AuthenticationRequest;
import fr.cs.authentificationproject.auth.AuthenticationResponse;
import fr.cs.authentificationproject.dto.UserDto;
import fr.cs.authentificationproject.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Admin")
public class AuthenticationController {

    private final UserService userService;


    @PostMapping("register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody UserDto user) {

        return ResponseEntity.ok(userService.registerAdmin(user));

    }

    @PostMapping("register/user")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody UserDto user) {

        return ResponseEntity.ok(userService.registerUser(user));

    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest user) {

        return ResponseEntity.ok(userService.authenticate(user));
    }
}
