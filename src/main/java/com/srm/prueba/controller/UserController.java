package com.srm.prueba.controller;

import com.srm.prueba.model.Usuario;
import com.srm.prueba.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/save")
    public String save(@RequestBody Usuario usuario){
           System.out.println("Name: "+usuario.getNombre());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepositorio.save(usuario);

        return "login.html";
    }
}
