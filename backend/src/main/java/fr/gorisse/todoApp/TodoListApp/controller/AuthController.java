package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.services.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

     @GetMapping("/isConnected")
    public String isConnected(Authentication authentication) {
         System.out.println("here");
        return "true";
    }


    @GetMapping("/login")
    public String myLogin(){
        return "Veuillez vous connecter";
    }


}
