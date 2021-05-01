package com.bcom.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bcom.dao.EventoDAO;
import com.bcom.model.Evento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/eventos")
public class EventoRest 
{
	@Autowired
	private EventoDAO servEvento;
	
	@GetMapping("/listar")
	private List<Evento> listar()
	{		
		return servEvento.findAll();
	} 
	
	@PostMapping("/guardar")
	private ResponseEntity<Evento> guardar(@RequestBody Evento evento) 
	{
		Evento eve = servEvento.save(evento);
		if(eve != null)
		{
			return new ResponseEntity<Evento>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Evento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{id}")
	private Optional<Evento> buscar(@PathVariable("id") Long id)
	{
		return servEvento.findById(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	private ResponseEntity<Evento> eliminar(@PathVariable("id") Long id)
	{
		Optional<Evento> eve = servEvento.findById(id);
		if(eve != null)
		{
			servEvento.deleteById(id);
			return new ResponseEntity<Evento>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Evento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/editar")
	private ResponseEntity<Evento> actualizar(@RequestBody Evento evento) 
	{
		Evento eve = servEvento.save(evento);
		if(eve != null)
		{
			return new ResponseEntity<Evento>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Evento>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
