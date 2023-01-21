
package com.operations.ratnaCrud.Controller;

import com.operations.ratnaCrud.Dto.CustomerRequestDto;
import com.operations.ratnaCrud.Dto.CustomerResponseDto;
import com.operations.ratnaCrud.Model.Customer;
import com.operations.ratnaCrud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    private Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/all")
    private List<Customer> getAll() {
        return customerService.getAll();
    }

    @PutMapping("/")
    private Customer update(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }


    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @PutMapping("/updateAddress")
    private CustomerResponseDto updateAddress(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.updateAddress(customerRequestDto);
    }
}

