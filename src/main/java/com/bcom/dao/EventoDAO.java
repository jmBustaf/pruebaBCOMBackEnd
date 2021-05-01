package com.bcom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcom.model.Evento;

public interface EventoDAO extends JpaRepository<Evento, Long> {

}
