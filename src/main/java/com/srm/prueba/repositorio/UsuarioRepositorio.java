package com.srm.prueba.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.prueba.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
