package com.example.eCommerce;

import com.example.eCommerce.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
  String authHeader = request.getHeader("Authorization");

  if(authHeader != null && authHeader.startsWith("Bearer ")) {
      String token = authHeader.substring(7);

      try {
          if (jwtUtil.validateJwtToken(token)) {
              String username = jwtUtil.extractUsername(token);
              var auth = new UsernamePasswordAuthenticationToken(username, null, List.of());
              SecurityContextHolder.getContext().setAuthentication(auth);
          }
          }catch(Exception e){
              System.out.println("Jwt validation failed:" + e.getMessage());

          }
      }

      filterChain.doFilter(request, response);
  }
}
