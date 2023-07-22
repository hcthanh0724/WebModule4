package com.example.demowebmodule4.repository;

import com.example.demowebmodule4.model.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceInvoiceDetailRepo extends CrudRepository<InvoiceDetail,Integer> {
}
