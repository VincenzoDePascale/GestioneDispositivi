package com.GestioneDispositivi.reposotiry;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.GestioneDispositivi.model.Dispositivo;
import com.GestioneDispositivi.model.Stato;
import com.GestioneDispositivi.model.Tipologia;
import com.GestioneDispositivi.model.Utente;

@Repository
public interface DispositiviRepository extends CrudRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo, Long> {
	
	Page<Dispositivo> findByStatoAndTipologia(Stato stato, Tipologia tipologia, Pageable pageable);
	List<Dispositivo> findByUtente(Utente u);
	Page<Dispositivo> findByStato(Stato stato, Pageable pageable);
	Page<Dispositivo> findByTipologia(Tipologia tipologia, Pageable pageable);

}