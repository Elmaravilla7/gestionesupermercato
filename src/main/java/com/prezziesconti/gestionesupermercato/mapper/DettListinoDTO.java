package com.prezziesconti.gestionesupermercato.mapper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DettListinoDTO {

    private Integer codArt;

    private Double prezzo;

    private Double sconto;

    private Double prezzoFinale;

}
