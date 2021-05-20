package com.sdistribuiti.prezziesconti.gestionesupermercato.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "dettlistini")
@Data
public class DettListino implements Serializable {

    @Id
    @Size(min = 5, max = 20, message = "{Size.DettListini.codArt.Validation}")
    @NotNull(message = "{NotNull.DettListini.codArt.Validation}")
    @Column(name = "CODART")
    private String codArt;

    @Min(value = (long) 0.01, message = "{Min.DettListini.prezzo.Validation}")
    @Column(name = "PREZZO")
    private Double prezzo;

    @Min(value = (long) 0.01, message = "{Min.DettListini.prezzo.Validation}")
    @Column(name = "SCONTO")
    private Double sconto;

    @Min(value = (long) 0.01, message = "{Min.DettListini.prezzo.Validation}")
    @Column(name = "PREZZOFINALE")
    private Double prezzoFinale;



}
