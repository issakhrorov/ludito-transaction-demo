package ludito.demo_transaction.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
  @Value("${security.signing_key}")
  private String secret;

  @Value("${security.signing_key.expiration}")
  private Long expiration;

  private SecretKey secretKey;

  @PostConstruct
  public void init() {
    byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);
    this.secretKey = Keys.hmacShaKeyFor(secretBytes);
  }

  public String generateToken(Long subject) {
    return Jwts.builder()
      .subject(subject.toString())
      .signWith(secretKey)
      .issuedAt(new Date(System.currentTimeMillis()))
      .expiration(new Date(System.currentTimeMillis() + expiration * 1000))
      .compact();
  }

  public String getUserIdFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUserIdFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  private Claims getAllClaimsFromToken (String token){
    return Jwts
      .parser()
      .verifyWith(secretKey)
      .build()
      .parseSignedClaims(token)
      .getPayload();
  }
}