package com.example.demowebmodule4.service.impl;

import com.example.demowebmodule4.model.InvoiceDetail;
import com.example.demowebmodule4.repository.InterfaceInvoiceDetailRepo;
import com.example.demowebmodule4.service.InterfaceCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements InterfaceCrudService<InvoiceDetail> {
    @Autowired
    InterfaceInvoiceDetailRepo interfaceInvoiceDetailRepo;


    @Override
    public List<InvoiceDetail> showAll() {
        return (List<InvoiceDetail>) interfaceInvoiceDetailRepo.findAll();
    }

    @Override
    public void create(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.save(invoiceDetail);
    }

    @Override
    public void update(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.save(invoiceDetail);
    }

    @Override
    public void delete(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.delete(invoiceDetail);
    }
}
