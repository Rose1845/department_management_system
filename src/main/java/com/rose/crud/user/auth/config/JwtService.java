package com.rose.crud.user.auth.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
  private final  String SECRET_KEY = "LbjwLB3AEYGE8pUJ0eaeQ5vmb09KBDaq";


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
//    generate token using userdetails
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

//    extract a single token
    public <T> T extractClaim(String token , Function<Claims,T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    /**
     * generate token
     */
    public String generateToken(Map<String, Object> extraClaims , UserDetails userDetails ){
        return  Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60* 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact(); //return and generate the token

}

//validate token
 public boolean isTokenValid(String token,UserDetails userDetails){
    final String username=extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
}

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
}

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
// extract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
