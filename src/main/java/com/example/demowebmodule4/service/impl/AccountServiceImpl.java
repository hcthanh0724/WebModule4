package com.example.demowebmodule4.service.impl;

import com.example.demowebmodule4.model.Account;
import com.example.demowebmodule4.repository.InterfaceAccountRepo;
import com.example.demowebmodule4.service.InterfaceCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements InterfaceCrudService<Account> {
    @Autowired
    InterfaceAccountRepo interfaceAccountRepo;


    @Override
    public List<Account> showAll() {
        return (List<Account>) interfaceAccountRepo.findAll();
    }

    @Override
    public void create(Account account) {
        interfaceAccountRepo.save(account);
    }

    @Override
    public void update(Account account) {
        interfaceAccountRepo.save(account);
    }

    @Override
    public void delete(Account account) {
        interfaceAccountRepo.delete(account);
    }
    public Account login(String username,String password){
        return interfaceAccountRepo.getAccountLogin(username,password);
    }
    public void register(Account account){
        interfaceAccountRepo.save(account);
    }
}
