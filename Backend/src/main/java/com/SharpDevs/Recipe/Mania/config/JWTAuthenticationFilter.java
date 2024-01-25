package com.SharpDevs.Recipe.Mania.config;

import com.SharpDevs.Recipe.Mania.Service.JWTService;
import com.SharpDevs.Recipe.Mania.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

private final JWTService jwtService;

private final UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    final String authHeader = request.getHeader(("Authorization"));
    final String jwt;
    final String userEmail;


    if(org.apache.commons.lang3.StringUtils.startsWith(authHeader,"Bearer ")){
        filterChain.doFilter(request,response);
        return;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUserName(jwt);

        UserDetails userDetails = userService.s;
    if(StringUtils.hasLength(userEmail) && SecurityContextHolder.getContext().getAuthentication()== null){
        

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.)
    }
    }
}
