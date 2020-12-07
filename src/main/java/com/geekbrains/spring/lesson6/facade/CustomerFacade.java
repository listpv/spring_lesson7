package com.geekbrains.spring.lesson6.facade;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.populators.CustomerPopulator;
import com.geekbrains.spring.lesson6.services.CustomerDataService;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacade {

    private CustomerPopulator customerPopulator;
    private CustomerService customerService;
    private CustomerDataService customerDataService;

    public CustomerFacade(CustomerPopulator customerPopulator, CustomerService customerService,
                          CustomerDataService customerDataService) {
        this.customerPopulator = customerPopulator;
        this.customerService = customerService;
        this.customerDataService = customerDataService;
    }

    public CustomerData getCustomerByName(String name){
        Customer customer = customerService.findCustomerByName(name);
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setPhone(customer.getPhone());
        customerData.setEmail(customer.getEmail());
        customerData.setBirthday(customer.getBirthday());
        return customerData;
    }

    public CustomerData getCustomerById(Long id){
        Customer customer = customerService.findById(id).get();
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setPhone(customer.getPhone());
        customerData.setEmail(customer.getEmail());
        customerData.setBirthday(customer.getBirthday());
        return customerData;
    }

    public List<CustomerData> getAllCustomerData(){
        return customerPopulator.convertAll(customerService.findAll());
    }

    public List<CustomerData> getAllCustomerDataFromService(){
        return customerDataService.findAllCustomerData();
    }
}