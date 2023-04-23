package com.GestioneDispositivi.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.GestioneDispositivi.model.Dispositivo;
import com.GestioneDispositivi.model.Utente;
import com.github.javafaker.Faker;

@Configuration
@PropertySource("classpath:application.properties")
public class UtenteConfiguration {
	
	@Bean("ParamsUser")
    @Scope("prototype")
    public Utente paramsUser(String username, String nome, String cognome, String email, Dispositivo dispositivo){
		return new Utente(null, username, nome, cognome, email, null);
	}
	
	@Bean("FakeUtente")
    @Scope("prototype")
    public Utente fakeUtente() {
		Faker fake = new Faker(new Locale("it-IT"));
		Utente u = new Utente();
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setUsername(u.getNome() + "_" + u.getCognome());
		u.setEmail(u.getNome() + "." + u.getCognome() + "@example.com");
		return u;
		
		
		
       
    }

}