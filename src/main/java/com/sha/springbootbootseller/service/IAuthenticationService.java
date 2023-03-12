package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.user;

public interface IAuthenticationService {
    user signInAndReturnJWT(user signInRequest);
}
