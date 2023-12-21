package fr.gorisse.todoApp.TodoListApp.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final JwtEncoder encoder;
    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateJwt(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> authority.startsWith("ROLE"))
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds( 7* 60 *60)) // 7 hours
                .subject(authentication.getName())
                .claim("scope", scope)
                .claim("iat", now.getEpochSecond())
                .claim("exp", now.plusSeconds(60 * 60).getEpochSecond())
                .build();
        var encoderParam = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(),claims);
        return encoder.encode(encoderParam).getTokenValue();
    }




}
