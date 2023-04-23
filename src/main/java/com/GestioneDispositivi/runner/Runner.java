package com.GestioneDispositivi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.GestioneDispositivi.model.Dispositivo;
import com.GestioneDispositivi.model.Stato;
import com.GestioneDispositivi.model.Tipologia;
import com.GestioneDispositivi.service.DispositiviService;
import com.GestioneDispositivi.service.UtenteService;

@Component
public class Runner implements ApplicationRunner {
	
	@Autowired
	UtenteService utenteService;
	
	@Autowired
	DispositiviService dispositiviService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("runner ok");
		
		for(int i = 0; i < 10; i++) {
		utenteService.saveFakeUtente();
		}
		
		Dispositivo d = new Dispositivo();
		d.setStato(Stato.ASSEGNATO);
		d.setTipologia(Tipologia.TABLET);
		d.setUtente(utenteService.findById(1l));
		dispositiviService.saveDispositivo(d);
		
		


	}
	
	

}