package com.geekbrains.spring.lesson6.services;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.repositories.CustomerDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDataService {

    private CustomerDataRepository customerDataRepository;

    public CustomerDataService(CustomerDataRepository customerDataRepository) {
        this.customerDataRepository = customerDataRepository;
    }

    public List<CustomerData> findAllCustomerData(){
        return customerDataRepository.findAllCustomerData();
    }
}
