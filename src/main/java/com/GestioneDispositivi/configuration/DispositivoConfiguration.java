package com.GestioneDispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.GestioneDispositivi.model.Dispositivo;
import com.GestioneDispositivi.model.Stato;
import com.GestioneDispositivi.model.Tipologia;

@Configuration
@PropertySource("classpath:application.properties")
public class DispositivoConfiguration {
	
	@Bean("ParamsD")
    @Scope("prototype")
    public Dispositivo paramsDispositivo(Tipologia tipologia,Stato stato){
		return new Dispositivo(null, tipologia, stato, null);
	}
	
}
