package com.GestioneDispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDispositivi.model.Utente;
import com.GestioneDispositivi.service.UtenteService;

@RestController
@RequestMapping("/Utenti")
public class UtenteController {
	
	
	@Autowired UtenteService utenteservice;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAll() {
	    List<Utente> utenti = utenteservice.findAll();
	    return new ResponseEntity<>(utenti, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return new ResponseEntity<Utente>(utenteservice.findById(id), HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<?> createUser(@RequestBody Utente u) {
        return new ResponseEntity<Utente>(utenteservice.saveUtente(u), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<String>(utenteservice.removeUtente(id), HttpStatus.OK);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Utente u) {
        return new ResponseEntity<Utente>(utenteservice.updateUtente(u), HttpStatus.CREATED);
    }
	
	
	

}