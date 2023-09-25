package com.triagem.api.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.triagem.api.Repository.CredenciaisRepository;

@Service
public class CredenciaisService implements UserDetailsService {

    private final CredenciaisRepository repository;

    public CredenciaisService(CredenciaisRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository
                .findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("User not found  " + username));
    }
}