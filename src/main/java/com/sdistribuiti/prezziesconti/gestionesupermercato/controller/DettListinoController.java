package com.sdistribuiti.prezziesconti.gestionesupermercato.controller;


import com.sdistribuiti.prezziesconti.gestionesupermercato.mapper.DettListinoDTO;
import com.sdistribuiti.prezziesconti.gestionesupermercato.service.DettListinoService;
import com.sdistribuiti.prezziesconti.gestionesupermercato.utility.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/gestione")
@CrossOrigin(origins="http://localhost:5071")
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
}
