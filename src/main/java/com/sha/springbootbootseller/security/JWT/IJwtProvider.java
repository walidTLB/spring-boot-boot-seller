package com.sha.springbootbootseller.security.JWT;

import com.sha.springbootbootseller.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken (UserPrincipal auth);

    Authentication getAuthentication (HttpServletRequest request);

    boolean ValidateToken(HttpServletRequest request);

}
