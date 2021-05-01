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

import com.bcom.dao.AsistenciaDAO;
import com.bcom.model.Asistencia;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/asistencias")
public class AsistenciaRest 
{
	@Autowired
	private AsistenciaDAO servAsistencia;
	
	@GetMapping("/listar")
	private List<Asistencia> listar()
	{		
		return servAsistencia.findAll();
	} 
	
	@PostMapping("/guardar")
	private ResponseEntity<Asistencia> guardar(@RequestBody Asistencia asistencia) 
	{
		Asistencia asis = servAsistencia.save(asistencia);
		if(asis != null)
		{
			return new ResponseEntity<Asistencia>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Asistencia>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/buscar/{id}")
	private Optional<Asistencia> buscar(@PathVariable("id") Long id)
	{
		return servAsistencia.findById(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	private ResponseEntity<Asistencia> eliminar(@PathVariable("id") Long id)
	{
		Asistencia asis = servAsistencia.getOne(id);
		if(asis != null)
		{
			servAsistencia.deleteById(id);
			return new ResponseEntity<Asistencia>(asis, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Asistencia>(asis, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/editar")
	private ResponseEntity<Asistencia> actualizar(@RequestBody Asistencia asistencia) 
	{
		Asistencia asis = servAsistencia.save(asistencia);
		if(asis != null)
		{
			return new ResponseEntity<Asistencia>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Asistencia>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
