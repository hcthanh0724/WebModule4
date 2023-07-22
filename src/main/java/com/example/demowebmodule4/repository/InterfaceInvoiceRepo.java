package com.example.demowebmodule4.repository;

import com.example.demowebmodule4.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceInvoiceRepo extends CrudRepository<Invoice,Integer> {
}
