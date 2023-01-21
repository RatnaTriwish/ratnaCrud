
package com.operations.ratnaCrud.Service;

import com.operations.ratnaCrud.Dto.CustomerRequestDto;
import com.operations.ratnaCrud.Dto.CustomerResponseDto;
import com.operations.ratnaCrud.Model.Customer;
import com.operations.ratnaCrud.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepo customerRepo;

    /**
     * this is used to create customer
     *
     * @param customer
     * @return Customer
     */

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    /**
     * this is used to get all customers list
     *
     * @return list of customers
     */
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer) {

        return customerRepo.save(customer);
    }

    /**
     * find the customer with customer id
     *
     * @param id
     * @return customer
     */

    public Customer findById(Long id) {
        return customerRepo.findById(id).get();
    }

    /**
     * delete customer with customer id
     *
     * @param id
     * @return string
     */

    public void deleteById(Long id) {
        try {
            Customer customer = customerRepo.findById(id)
                    .orElseThrow(() -> new Exception("customer not found"));
            customerRepo.delete(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerResponseDto updateAddress(CustomerRequestDto customerRequestDto) {

        try {
            Customer customer = customerRepo.findById(customerRequestDto.getId())
                    .orElseThrow(() -> new Exception("customer not found"));
            customer.setAddress(customerRequestDto.getAddress());
            Customer c = customerRepo.save(customer);
            return convertToCustomerResponse(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private CustomerResponseDto convertToCustomerResponse(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerName(customer.getCustomerName());
        customerResponseDto.setAddress(customer.getAddress());
        customerResponseDto.setCity(customer.getCity());
        customerResponseDto.setCountry(customer.getCountry());
        customerResponseDto.setPostalCode(customer.getPostalCode());
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setContactName(customer.getContactName());
        return customerResponseDto;

    }

    /*public Customer updateAddress(CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepo.updateAddress(customerRequestDto.getAddress(), customerRequestDto.getId());
        return customer;
    }
*/
}
