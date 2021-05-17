package com.sdistribuiti.prezziesconti.gestionesupermercato.service;

import com.sdistribuiti.prezziesconti.gestionesupermercato.utility.exception.NotFoundException;

import com.sdistribuiti.prezziesconti.gestionesupermercato.mapper.DettListinoDTO;
import com.sdistribuiti.prezziesconti.gestionesupermercato.entity.DettListino;

public interface DettListinoService {

    public Iterable<DettListino> catchAll();

    public void inserisci(DettListino dettListino);

    public void elimina(String codArt) throws NotFoundException;

    public DettListino catchFromCodArt(String codArt);

    public DettListinoDTO catchFromCodArtDTO(String codArt) throws NotFoundException;


}
