package com.sha.springbootbootseller.util;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTH_Header ="authorization";
    public static final String AUTH_TOKEN_TYPE = "bearer";
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";
    public static SimpleGrantedAuthority convertToAuthority (String role) {
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role: ROLE_PREFIX+role;
        return new SimpleGrantedAuthority(formattedRole);
    }
 public static  String extractAuthTokenFromRequest (HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTH_Header);
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX))
        {return bearerToken.substring(7);}
     return null;
 }

}
