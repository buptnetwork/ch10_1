package cn.edu.bupt.ch10_1.controller;

import cn.edu.bupt.ch10_1.dao.CustomerRepository;
import cn.edu.bupt.ch10_1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/add")
    String add(String firstName, String lastName){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "ok!";
    }

    @GetMapping("/find")
    List<Customer> find(String lastName){
        List<Customer> customerList = customerRepository.findByLastName(lastName);
        return customerList;
    }
}

