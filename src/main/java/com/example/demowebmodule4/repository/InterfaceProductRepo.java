package com.example.demowebmodule4.repository;

import com.example.demowebmodule4.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterfaceProductRepo extends PagingAndSortingRepository<Product,Integer> {
}
