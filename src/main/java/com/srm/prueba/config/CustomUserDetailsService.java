package com.srm.prueba.config;

import com.srm.prueba.model.Usuario;
import com.srm.prueba.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user;
        org.springframework.security.core.userdetails.User springUser = null;

        user = repo.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user != null) {

            springUser = new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    true, true, true, true,
                    authorities);
            return springUser;
        } else {
            //throw new UsernameNotFoundException(String.format("Username not found"));
            return null;

        }
        //return null;
    }

}
