package com.example.demowebmodule4.service;

import java.util.List;

public interface InterfaceCrudService<E> {
    List<E> showAll();
    void create(E e);
    void update(E e);
    void delete(E e);
}
