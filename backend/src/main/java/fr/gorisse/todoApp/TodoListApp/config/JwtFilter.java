package fr.gorisse.todoApp.TodoListApp.config;

import fr.gorisse.todoApp.TodoListApp.services.IUserService;
import fr.gorisse.todoApp.TodoListApp.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final IUserService userService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
        this.userService = null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = this.jwtService.getUsername(token);
        }
        if (
                username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null &&
                !this.jwtService.isTokenExpired(token)
        ) {
            UserDetails user = this.userService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
