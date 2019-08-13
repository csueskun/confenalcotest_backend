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

import com.suescun.model.PremioPersona;
import com.suescun.repo.IPremioPersonaRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/premios_personas")
public class PremioPersonaRestController {
	
	@Autowired
	private IPremioPersonaRepo repo;
	
	@GetMapping
	public List<PremioPersona> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public void guardar(@RequestBody PremioPersona premioPersona) {
		repo.save(premioPersona);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
}
