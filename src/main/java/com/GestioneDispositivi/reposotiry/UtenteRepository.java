package com.GestioneDispositivi.reposotiry;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.GestioneDispositivi.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long>, PagingAndSortingRepository<Utente, Long> {

	boolean existsByEmail(String email);
	Optional<Utente> findByEmail(String email);
	
	boolean existsByUsername(String username);	
	Optional<Utente> findByUsername(String username);
	
}