package com.sdistribuiti.prezziesconti.gestionesupermercato.service;

import com.sdistribuiti.prezziesconti.gestionesupermercato.entity.DettListino;
import com.sdistribuiti.prezziesconti.gestionesupermercato.mapper.DettListinoDTO;
import com.sdistribuiti.prezziesconti.gestionesupermercato.repository.DettListinoRepository;
import com.sdistribuiti.prezziesconti.gestionesupermercato.utility.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DettListinoServiceImpl implements  DettListinoService{

    @Autowired
    private DettListinoRepository dettListRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Iterable<DettListino> catchAll()
    {
        return dettListRepo.findAll();
    }

    @Override
    @Transactional
    public void inserisci(DettListino dettListino)
    {

        dettListRepo.save(dettListino);
    }

    @Override
    @Transactional
    public void elimina(String codArt)throws NotFoundException
    {
        DettListino art= dettListRepo.findByCodArt(codArt);

        if(art==null){
            throw new NotFoundException("L'articolo non esite!");
        }

        dettListRepo.delete(art);
    }

    @Override
    public DettListino catchFromCodArt(String codArt) {
        return dettListRepo.findByCodArt(codArt);
    }

    @Override
    public DettListinoDTO catchFromCodArtDTO(String codArt) throws NotFoundException {

        if(!dettListRepo.existsById(codArt)){
            throw new NotFoundException("L'articolo non è stato trovato!");
        }

        DettListinoDTO artDTO = mapper.map(dettListRepo.findByCodArt(codArt), DettListinoDTO.class);

        return artDTO;

    }
}
