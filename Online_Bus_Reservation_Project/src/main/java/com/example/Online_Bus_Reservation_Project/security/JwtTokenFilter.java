package com.example.Online_Bus_Reservation_Project.security;
    import com.example.Online_Bus_Reservation_Project.entity.User;
    import com.example.Online_Bus_Reservation_Project.repository.UserRepo;
    import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

    @Service
    @AllArgsConstructor
    public class JwtTokenFilter extends OncePerRequestFilter {
        JwtUtil jwtUtil;
        UserRepo userRepository;

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = authorizationHeader.split(" ")[1].trim();
            if (!jwtUtil.validate(token)) {
                filterChain.doFilter(request, response);
                return;
            }
            String username = jwtUtil.getUsername(token);
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not exists in the DB"));
            Set<GrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toSet());

            UsernamePasswordAuthenticationToken upAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(username, user.getPassword(), authorities);
            upAuthenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(upAuthenticationToken);
            filterChain.doFilter(request, response);
        }
    }

