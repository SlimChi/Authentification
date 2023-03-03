package fr.cs.authentificationproject.controllers;


import fr.cs.authentificationproject.auth.AuthenticationRequest;
import fr.cs.authentificationproject.auth.AuthenticationResponse;
import fr.cs.authentificationproject.auth.RegisterRequest;
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


    @PostMapping("register/user")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(userService.registerUser(request));

    }

    @PostMapping("register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(userService.registerAdmin(request));

    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(userService.authenticate(request));
    }
}
