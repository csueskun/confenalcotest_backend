package com.suescun.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suescun.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
