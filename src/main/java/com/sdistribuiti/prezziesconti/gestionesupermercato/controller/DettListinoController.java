package com.sdistribuiti.prezziesconti.gestionesupermercato.controller;


import com.sdistribuiti.prezziesconti.gestionesupermercato.entity.DettListino;
import com.sdistribuiti.prezziesconti.gestionesupermercato.mapper.DettListinoDTO;
import com.sdistribuiti.prezziesconti.gestionesupermercato.service.DettListinoService;
import com.sdistribuiti.prezziesconti.gestionesupermercato.utility.exception.BindingException;
import com.sdistribuiti.prezziesconti.gestionesupermercato.utility.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/gestione")
@CrossOrigin(origins="http://localhost:4200")
public class DettListinoController {

    @Autowired
    private DettListinoService serv;

    @Autowired
    private ResourceBundleMessageSource errMessage;

    private static final Logger logger = LoggerFactory.getLogger(DettListinoController.class);

    @GetMapping(value = "/ricerca/fromcodice/{codart}", produces = "application/json")
    public ResponseEntity<DettListinoDTO> searchByCod(@PathVariable("codart") String codArt)
            throws NotFoundException
    {
        return new ResponseEntity<DettListinoDTO>(serv.catchFromCodArtDTO(codArt), HttpStatus.OK);
    }

    @GetMapping(value = "/ricerca/fromcodice/prezzo/{codart}", produces = "application/json")
    public Double prezzoFinaleByCod(@PathVariable("codart") String codArt)
            throws NotFoundException
    {
        return serv.catchFromCodArtDTO(codArt).getPrezzoFinale();
    }


    //vale anche come modifica
    @PostMapping(value = "/inserisci")
    public ResponseEntity<?> inserisciArticolo(@Valid @RequestBody DettListino articolo, BindingResult bindingResult)
            throws BindingException,IllegalArgumentException
    {
        if (bindingResult.hasErrors())
        {
            throw new BindingException(errMessage.getMessage(bindingResult.getFieldError(), LocaleContextHolder.getLocale()));
        }

        try {
            serv.inserisci(articolo);
        }catch(Exception e){
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/elimina/{codart}", method = RequestMethod.DELETE, produces = "application/json" )
    public ResponseEntity<?> eliminaArticolo(@PathVariable("codart") String codArt)
            throws NotFoundException
    {
        serv.elimina(codArt);

        return new ResponseEntity<>( new HttpHeaders(), HttpStatus.OK);

    }
}
