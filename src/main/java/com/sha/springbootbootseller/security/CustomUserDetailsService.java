package com.sha.springbootbootseller.security;

import com.sha.springbootbootseller.model.user;
import com.sha.springbootbootseller.service.IUserService;
import com.sha.springbootbootseller.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserService userService;

    public CustomUserDetailsService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
user user=  userService.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException(username));
Set<GrantedAuthority> authorities= Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                        .user(user).username(username).id(user.getId()).password(user.getPassword()).
                authorities(authorities).build();
    }
}
