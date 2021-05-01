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

import com.bcom.dao.UsuarioDAO;
import com.bcom.model.Usuario;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/usuarios")
public class UsuarioRest 
{
	@Autowired
	private UsuarioDAO servUsuario;
	
	@GetMapping("/listar")
	private List<Usuario> listar()
	{		
		return servUsuario.findAll();
	} 
	
	@PostMapping("/guardar")
	private ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) 
	{
		Usuario usu = servUsuario.save(usuario);
		if(usu != null)
		{
			return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Usuario>(usu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{id}")
	private Optional<Usuario> buscar(@PathVariable("id") Long id)
	{
		return servUsuario.findById(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	private ResponseEntity<Usuario> eliminar(@PathVariable("id") Long id)
	{
		Usuario usu = servUsuario.getOne(id);
		if(usu != null)
		{
			servUsuario.deleteById(id);
			return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Usuario>(usu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/editar")
	private ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario) 
	{
		Usuario usu = servUsuario.save(usuario);
		if(usu != null)
		{
			return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Usuario>(usu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
