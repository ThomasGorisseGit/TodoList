package fr.gorisse.todoApp.TodoListApp.controller;

import fr.gorisse.todoApp.TodoListApp.entity.record.UsernamePassword;
import fr.gorisse.todoApp.TodoListApp.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class  AuthController {
    private final JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    @PostMapping("/connect")
    public Map<String, String> connect(
            @RequestBody UsernamePassword usernamePassword
            ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usernamePassword.username(), usernamePassword.password())
        );
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(usernamePassword.username());
        }
        return null;
    }

    @GetMapping("/isConnected")
    public String isConnected(){
        return "you are connected";
    }


}
