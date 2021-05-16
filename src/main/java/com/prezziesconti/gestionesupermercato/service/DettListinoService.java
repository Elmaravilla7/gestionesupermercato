package com.prezziesconti.gestionesupermercato.service;

import com.prezziesconti.gestionesupermercato.utility.exception.NotFoundException;
import org.springframework.data.domain.Pageable;

import com.prezziesconti.gestionesupermercato.mapper.DettListinoDTO;
import com.prezziesconti.gestionesupermercato.entity.DettListino;

public interface DettListinoService {

    public Iterable<DettListino> catchAll();

    public void inserisci(DettListino dettListino);

    public void elimina(String codArt) throws NotFoundException;

    public DettListino catchFromCodArt(String codArt);

    public DettListinoDTO catchFromCodArtDTO(String codArt) throws NotFoundException;


}
