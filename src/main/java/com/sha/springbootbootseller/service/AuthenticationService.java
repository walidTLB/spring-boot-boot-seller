package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.user;
import com.sha.springbootbootseller.security.JWT.IJwtProvider;
import com.sha.springbootbootseller.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
@Autowired
    private AuthenticationManager authenticationManager;
@Autowired
private IJwtProvider jwtProvider;
@Override
public user signInAndReturnJWT(user signInRequest){
    Authentication authentication = authenticationManager.
            authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequest.getUsername(), signInRequest.getPassword())
            );

    UserPrincipal userPrincipal = (UserPrincipal)  authentication.getPrincipal();
String jwt = jwtProvider.generateToken(userPrincipal);

user signInUser = userPrincipal.getUser();
signInUser.setToken(jwt);

return  signInUser;
}
}
