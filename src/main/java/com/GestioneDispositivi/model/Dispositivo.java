package com.GestioneDispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dispositivi")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Tipologia tipologia;	
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
		
	@ManyToOne
	@JsonIgnoreProperties({ "dispositivi" })
	private Utente utente;
	
}
