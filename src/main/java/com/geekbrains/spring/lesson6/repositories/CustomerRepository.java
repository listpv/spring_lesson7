package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    Customer findCustomerByName(String name);
}
