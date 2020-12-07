package com.geekbrains.spring.lesson6.controllers.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.facade.CustomerFacade;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/api/v1")
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerFacade customerFacade;

    public CustomerRestController(CustomerService customerService, CustomerFacade customerFacade) {
        this.customerService = customerService;
        this.customerFacade = customerFacade;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @JsonView(CustomerView.IdName.class)
    public List<Customer> customerToXml() {
        return customerService.findAll();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameBirthday.class)
    public List<Customer> customerToJson() {
        return customerService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameBirthdayPhoneEmailAddressOrder.class)
    public Customer getCustomerById(
            @PathVariable("id") Long id
    ) {
        return customerService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer id=" + id + " not found"));
    }

    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer
    ) {
        customer.setId(null);
        return customerService.saveOrUpdate(customer);
    }

    @PutMapping("/{id}")
    public Customer putCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer
    ) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(
            @PathVariable("id") Long id
    ) {
        customerService.remove(id);
    }

    @GetMapping(value = "/jsonData/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public CustomerData customerDataToJson(
            @PathVariable Long id
    ){
        return customerFacade.getCustomerById(id) ;
    }

    @GetMapping(value = "/jsonDataName/{name}",produces= MediaType.APPLICATION_JSON_VALUE)
    public CustomerData customerDataToJsonByName(
            @PathVariable String name
    ){
        return customerFacade.getCustomerByName(name) ;
    }

    @GetMapping(value = "/jsonData")
    public List<CustomerData> customerDataToJson(){
        return customerFacade.getAllCustomerDataFromService();
    }


}
