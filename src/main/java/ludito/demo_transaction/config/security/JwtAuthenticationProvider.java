package ludito.demo_transaction.config.security;

import ludito.demo_transaction.config.jwt.JwtTokenUtil;
import ludito.demo_transaction.exception.Exceptions;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import static ludito.demo_transaction.exception.Logging.LoggedError;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final JwtTokenUtil jwtTokenUtil;

  public JwtAuthenticationProvider(JwtTokenUtil jwtTokenUtil) {
    this.jwtTokenUtil = jwtTokenUtil;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    if (authentication == null || authentication.getCredentials() == null) {
      throw LoggedError(new Exceptions.CustomForbiddenException("Token is missing"));
    }

    String jwtToken = authentication.getCredentials().toString();

    try {
      String userId = jwtTokenUtil.getUserIdFromToken(jwtToken);

      return new UsernamePasswordAuthenticationToken(userId, null);

    } catch (Exception ex) {
      throw LoggedError(new Exceptions.CustomForbiddenException("Invalid JWT token"));
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}