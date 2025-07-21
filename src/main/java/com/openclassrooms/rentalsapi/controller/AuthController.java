package com.openclassrooms.rentalsapi.controller;


import com.openclassrooms.rentalsapi.DTO.LoginDTO;
import com.openclassrooms.rentalsapi.DTO.RegisterDTO;
import com.openclassrooms.rentalsapi.DTO.TokenDTO;
import com.openclassrooms.rentalsapi.DTO.UserDTO;
import com.openclassrooms.rentalsapi.mapper.UserMapper;
import com.openclassrooms.rentalsapi.model.DBUser;
import com.openclassrooms.rentalsapi.repository.UserRepository;
import com.openclassrooms.rentalsapi.service.CustomUserDetailsService;
import com.openclassrooms.rentalsapi.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


import com.openclassrooms.rentalsapi.service.JWTService;

import java.security.Principal;


@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoints pour l'authentification")
public class AuthController {


    private JWTService jwtService;
    private CustomUserDetailsService customUserDetailsService;
    private UserRepository userRepository;
    private UserService userService;
    private UserMapper userMapper;


    public AuthController(JWTService jwtService, CustomUserDetailsService customUserDetailsService, UserRepository userRepository, UserService userService, UserMapper userMapper) {
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    @Operation(summary = "Connexion utilisateur", description = "Authentifie un utilisateur et retourne un token JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Connexion réussie"),
            @ApiResponse(responseCode = "401", description = "Identifiants incorrects")
    })
    public TokenDTO login(@RequestBody LoginDTO loginDTO) {
        TokenDTO token = new TokenDTO();
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        customUserDetailsService.comparePasswords(email, password);

        token.setToken(jwtService.generateToken(loginDTO));
        return token;
    }

    @PostMapping("/register")
    @Operation(summary = "Inscription utilisateur", description = "Crée un nouveau compte utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscription réussie"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public String register(@RequestBody RegisterDTO registerDTO) throws ResponseStatusException{
        String email = registerDTO.getEmail();
        String password = registerDTO.getPassword();
        String name = registerDTO.getName();
        customUserDetailsService.registerUser(email, password, name);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);

        String token = jwtService.generateToken(loginDTO);
        return token;
    }

    @GetMapping("/me")
    @Operation(summary = "Profil utilisateur", description = "Récupère les informations de l'utilisateur connecté")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profil récupéré avec succès"),
            @ApiResponse(responseCode = "401", description = "Token JWT invalide ou manquant")
    })
        public UserDTO getUserWithJWT(Principal principal){
            DBUser dbUser = userService.getUserByMail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            UserDTO userDTO = userMapper.toDTO(dbUser);
            return userDTO;
        }

}