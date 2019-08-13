package com.suescun.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suescun.model.Persona;
import com.suescun.repo.IPersonaRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/personas")
public class PersonaRestController {
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping
	public List<Persona> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public void guardar(@RequestBody Persona persona) {
		repo.save(persona);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
}
