package ludito.demo_transaction.config.jwt;

import org.jetbrains.annotations.NotNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
  @Autowired
  private JwtTokenUtil tokenUtil;

  @Override
  protected void doFilterInternal(
    @NotNull HttpServletRequest request,
    @NotNull HttpServletResponse response,
    @NotNull FilterChain filterChain
  ) throws ServletException, IOException {
    final String authorizationHeader = request.getHeader("Authorization");

    String jwt = null;
    String userId = null;

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(7);
      try {
        if (!tokenUtil.isTokenExpired(jwt)) {
          userId = tokenUtil.getUserIdFromToken(jwt);

          var authToken = new UsernamePasswordAuthenticationToken(
            userId,
            null,
            List.of() // you can add roles here if needed
          );
          authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authToken);
        }
      } catch (Exception e) {
        // Token is invalid or expired — let the request pass without authentication
        // OR respond immediately (optional)
        logger.warn("Invalid JWT token: " + e.getMessage());
      }
    }

    filterChain.doFilter(request, response);
  }
}
