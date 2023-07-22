package com.example.demowebmodule4.repository;

import com.example.demowebmodule4.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InterfaceAccountRepo extends CrudRepository<Account,Integer> {
    @Query(value = "select a from Account a where a.username =:u and a.password=:p")
    Account getAccountLogin(@Param("u")String username,@Param("p") String password);
}
