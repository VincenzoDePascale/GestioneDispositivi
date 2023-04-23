package com.GestioneDispositivi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi.model.Dispositivo;
import com.GestioneDispositivi.model.Stato;
import com.GestioneDispositivi.model.Tipologia;
import com.GestioneDispositivi.reposotiry.DispositiviRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositiviService {

	@Autowired private DispositiviRepository dispositiviRepository;
	
	
	
	public Dispositivo saveDispositivo(Dispositivo d) {
		dispositiviRepository.save(d);
		return d;
	}
	
	public String removeDispositivo(Long id) {
		if (!dispositiviRepository.existsById(id)) {
			throw new EntityNotFoundException("id del dispositivo non esiste");
		}
		dispositiviRepository.deleteById(id);
		return "dispostivo rimosso dal db";
	}
	
	public Dispositivo updateDispositivo(Dispositivo d) {
		if (!dispositiviRepository.existsById(d.getId())) {
			throw new EntityNotFoundException("il dispositivo che stai provando ad aggiornare non esiste");
		}
		dispositiviRepository.save(d);
		return d;
	}
	
	public Dispositivo findById(Long id) {
		if(!dispositiviRepository.existsById(id)) {
			throw new EntityNotFoundException("non esiste un dispositivo associato a questo id");
		}
		return dispositiviRepository.findById(id).get();	
	}

	public Page<Dispositivo> findAll(Pageable pageable){
		return (Page<Dispositivo>) dispositiviRepository.findAll(pageable);
	}
	
	public Page<Dispositivo> findByStato(Stato stato, Pageable pageable){
		return (Page<Dispositivo>) dispositiviRepository.findByStato(stato, pageable);
	}
	
	public Page<Dispositivo> findByTipologia(Tipologia tipo, Pageable pageable){
		return (Page<Dispositivo>) dispositiviRepository.findByTipologia(tipo, pageable);
	}
	
	public Page<Dispositivo> findByStatoAndTipologia(Stato stato, Tipologia tipo, Pageable pageable){
		return (Page<Dispositivo>) dispositiviRepository.findByStatoAndTipologia(stato, tipo, pageable);
	}
}