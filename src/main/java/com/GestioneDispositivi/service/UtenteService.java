package com.GestioneDispositivi.service;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.model.Utente;
import com.GestioneDispositivi.reposotiry.DispositiviRepository;
import com.GestioneDispositivi.reposotiry.UtenteRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	@Autowired private UtenteRepository utenteRepository;
	@Autowired private DispositiviRepository dispositiviRepository;
	
	@Autowired @Qualifier("FakeUtente") private ObjectProvider<Utente> fakeEmployeeProvider;
	
	public Utente saveUtente(Utente e) {
		if(utenteRepository.existsByEmail(e.getEmail()) || utenteRepository.existsByUsername(e.getUsername())) {
			throw new EntityExistsException("Utente o username già prensernti");
		}
		utenteRepository.save(e);
		return e;
	}
	
	public void saveFakeUtente() {	
		saveUtente(fakeEmployeeProvider.getObject());
	}
	
	public String removeUtente(Long id) {
		if (!utenteRepository.existsById(id)) {
			throw new EntityNotFoundException("l'utente non esitste");
		}
		if(dispositiviRepository.findByUtente(utenteRepository.findById(id).get()).size() > 0) {
			throw new EntityExistsException("l'utente ha dispositivi assegnati, eliminali prima");
		}
		utenteRepository.deleteById(id);
		return "utentre cancellato dal database";
	}
	
	public Utente updateUtente(Utente e) {
		if (!utenteRepository.existsById(e.getId())) {
			throw new EntityNotFoundException("Employee ID doesnt exists on No Id Specified!!");
		}
		utenteRepository.save(e);
		e.setDispositivi(dispositiviRepository.findByUtente(e));
		return e;
	}
	
	public Utente findById(Long id) {
		if(!utenteRepository.existsById(id)) {
			throw new EntityNotFoundException("utente ricercato non esiste");
		}
		return utenteRepository.findById(id).get();	
	}
	
	public Utente findByEmail(String email) {
		if(!utenteRepository.existsByEmail(email)) {
			throw new EntityNotFoundException("non esiste l'email nel db");
		}
		return utenteRepository.findByEmail(email).get();	
	}
	
	public Utente findByUsername(String username) {
		if(!utenteRepository.existsByUsername(username)) {
			throw new EntityNotFoundException("non esistre questo userrname nel db");
		}
		return utenteRepository.findByUsername(username).get();	
	}

	public List<Utente> findAll() {
		return (List<Utente>) utenteRepository.findAll();
	}
	
}
