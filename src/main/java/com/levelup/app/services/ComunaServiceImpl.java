package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.entities.Comuna;
import com.levelup.app.repositories.ComunaRepository;

@Service
public class ComunaServiceImpl implements ComunaServices {

    @Autowired
    private ComunaRepository comunaRepository;

    @Transactional
    @Override
    public List<Comuna> findAll() {
        List<Comuna> comunas = (List<Comuna>) comunaRepository.findAll();
        return comunas;
    }

}
