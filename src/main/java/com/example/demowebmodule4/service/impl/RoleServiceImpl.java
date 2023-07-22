package com.example.demowebmodule4.service.impl;

import com.example.demowebmodule4.model.Role;
import com.example.demowebmodule4.repository.InterfaceRoleRepo;
import com.example.demowebmodule4.service.InterfaceCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements InterfaceCrudService<Role> {
    @Autowired
    InterfaceRoleRepo interfaceRoleRepo;

    @Override
    public List<Role> showAll() {
        return (List<Role>) interfaceRoleRepo.findAll();
    }

    @Override
    public void create(Role role) {
        interfaceRoleRepo.save(role);
    }

    @Override
    public void update(Role role) {
        interfaceRoleRepo.save(role);
    }

    @Override
    public void delete(Role role) {
        interfaceRoleRepo.delete(role);
    }
}
