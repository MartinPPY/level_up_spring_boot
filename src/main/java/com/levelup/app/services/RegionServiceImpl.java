package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelup.app.entities.Region;
import com.levelup.app.repositories.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return (List<Region>) regionRepository.findAll();
    }


    
}
