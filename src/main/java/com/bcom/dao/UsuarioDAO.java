package com.bcom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcom.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> 
{

}
