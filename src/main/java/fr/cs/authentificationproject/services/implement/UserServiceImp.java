package fr.cs.authentificationproject.services.implement;

import fr.cs.authentificationproject.auth.AuthenticationRequest;
import fr.cs.authentificationproject.auth.AuthenticationResponse;
import fr.cs.authentificationproject.auth.RegisterRequest;
import fr.cs.authentificationproject.config.JwtService;
import fr.cs.authentificationproject.dto.UserDto;
import fr.cs.authentificationproject.entities.Role;
import fr.cs.authentificationproject.entities.User;
import fr.cs.authentificationproject.repositories.UserRepository;
import fr.cs.authentificationproject.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author slimane
 * @Project authentification
 */

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse registerAdmin(RegisterRequest request) {

        Optional<User> userOptional = userRepository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(1,"ADMIN"))
                .build();
        userRepository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public AuthenticationResponse registerUser(RegisterRequest request) {

        Optional<User> userOptional = userRepository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(2,"USER"))
                .build();
        userRepository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );

        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
    @Override
    @Transactional
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID : " + id));
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id){

        return userRepository.findById(id);
    }

    @Override
    public void updateUser(Integer id, String firstName, String lastName, String email, String password){


        User updateUser = userRepository.findById(id).orElseThrow();

        updateUser.setEmail(email);
        updateUser.setFirstName(firstName);
        updateUser.setLastName(lastName);
        updateUser.setPassword(passwordEncoder.encode(password));


    }
}
