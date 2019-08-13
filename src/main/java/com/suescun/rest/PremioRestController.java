package com.suescun.rest;

import java.util.Collections;
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
import com.suescun.model.Premio;
import com.suescun.model.PremioPersona;
import com.suescun.repo.IPersonaRepo;
import com.suescun.repo.IPremioPersonaRepo;
import com.suescun.repo.IPremioRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/premios")
public class PremioRestController {
	
	@Autowired
	private IPremioRepo repo;
	
	@Autowired
	private IPersonaRepo personaRepo;
	
	@Autowired
	private IPremioPersonaRepo premioPersonaRepo;
	
	@GetMapping
	public List<Premio> listar(){
		return repo.findAll();
	}
	
	@PostMapping
	public int guardar(@RequestBody Premio premio) {
		premio = repo.save(premio);
		return premio.getId();
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
	
	@GetMapping(value = "/repartir")
	public int repartirPremios() {
		int cantidad = 0;
		List<Premio> premios = repo.findAll();
		List<Persona> personas = personaRepo.findAll();
	    for(Persona persona : personas) {
	    	boolean asignado = false;
	    	Collections.shuffle(premios);
	    	for(Premio premio : premios) {
	    		if(premio.getCantidad()>0) {
	    			PremioPersona premioPersona = new PremioPersona();
	    			premioPersona.setPersona(persona);
	    			premioPersona.setPremio(premio);
	    			premioPersonaRepo.save(premioPersona);
	    			premio.setCantidad(premio.getCantidad()-1);
	    			repo.save(premio);
	    			asignado = true;
	    			cantidad++;
	    			break;
	    		}
	    	}
	    	if(!asignado) {
	    		break;
	    	}
	    }	 
	    return cantidad;
	}
}
