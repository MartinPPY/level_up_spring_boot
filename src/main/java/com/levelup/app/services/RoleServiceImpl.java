package com.levelup.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelup.app.models.Role;
import com.levelup.app.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        return roles;
    }

}
