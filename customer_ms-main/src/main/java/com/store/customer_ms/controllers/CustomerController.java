package com.store.customer_ms.controllers;

import com.store.customer_ms.exceptions.CustomerNotFoundException;
import com.store.customer_ms.models.Customer;
import com.store.customer_ms.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/{id}")
    Customer getCustomer(@PathVariable String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("el documento " + id));
    }

    @GetMapping("/customers")
    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/customers")
    Customer editCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable String id){
        Optional<Customer> customer = customerRepository.findById(id);
//        customer.ifPresent(value -> customerRepository.delete(value));
        if (customer.isPresent()) customerRepository.delete(customer.get());
        else throw new CustomerNotFoundException("el documento " + id);
    }
}
