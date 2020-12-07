package com.geekbrains.spring.lesson6.populators;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerPopulator implements Populator<Customer, CustomerData>{

    @Override
    public CustomerData populate(Customer customer, CustomerData customerData) {
        if(customer == null || customerData == null){
            return null;
        }
        customerData.setId(customer.getId());
        customerData.setCreateDate(customer.getCreateDate());
        customerData.setModifyDate(customer.getModifyDate());
        customerData.setName(customer.getName());
        customerData.setEmail(customer.getEmail());
        customerData.setPhone(customer.getPhone());
        customerData.setBirthday(customer.getBirthday());
        customerData.setAddress(customer.getAddress());
        customerData.setDescription(customer.getDescription());
//        customerData.setOrders(customer.getOrders());
        return customerData;
    }

    @Override
    public CustomerData populate(Customer customer) {
        return populate(customer, new CustomerData());
    }
}
