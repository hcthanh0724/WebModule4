package com.example.demowebmodule4.service.impl;

import com.example.demowebmodule4.model.Invoice;
import com.example.demowebmodule4.repository.InterfaceInvoiceRepo;
import com.example.demowebmodule4.service.InterfaceCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImpl implements InterfaceCrudService<Invoice> {
    @Autowired
    InterfaceInvoiceRepo interfaceInvoiceRepo;
    @Override
    public List<Invoice> showAll() {
        return (List<Invoice>) interfaceInvoiceRepo.findAll();
    }

    @Override
    public void create(Invoice invoice) {
        interfaceInvoiceRepo.save(invoice);
    }

    @Override
    public void update(Invoice invoice) {
        interfaceInvoiceRepo.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        interfaceInvoiceRepo.delete(invoice);
    }
}
