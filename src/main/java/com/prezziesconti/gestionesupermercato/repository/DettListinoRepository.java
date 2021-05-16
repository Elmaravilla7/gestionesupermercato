package com.prezziesconti.gestionesupermercato.repository;

import com.prezziesconti.gestionesupermercato.entity.DettListino;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DettListinoRepository extends PagingAndSortingRepository<DettListino, String> {

    DettListino findByCodArt(String codArt);
}
