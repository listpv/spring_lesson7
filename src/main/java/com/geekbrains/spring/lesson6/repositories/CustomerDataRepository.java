package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDataRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new com.geekbrains.spring.lesson6.data.CustomerData(c.id, c.createDate, c.modifyDate, " +
            "c.name, c.email, c.phone, c.birthday, c.address, c.description" +
//            ", c.orders" +
            ") FROM Customer c")
    List<CustomerData> findAllCustomerData();


}
