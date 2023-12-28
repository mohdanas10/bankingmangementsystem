package com.bankingmangementsystemwithreact.bankingmangementsystem.Controller;

import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Customer;
import com.bankingmangementsystemwithreact.bankingmangementsystem.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://silly-twilight-05b62d.netlify.app")
@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        return this.customerServices.addCustomer(customer);
    }

    @GetMapping("/allCustomer")
    public List<Customer> allCustomer (){
        return this.customerServices.allCustomer();
    }

    @GetMapping("/customerById/{id}")
    public Customer customerById (@PathVariable("id") int id) {
        return this.customerServices.customerById(id);
    }

    @PutMapping("/updateCustomer/{id}")
    public String updateCustomer (@PathVariable("id") int id , @RequestBody Customer customer){
        return this.customerServices.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer (@PathVariable("id") int id ){
         this.customerServices.deleteCustomer(id);
    }

    @GetMapping("/totalCustomer")
    public int totalCustomer(){
        return this.customerServices.totalCustomer();
    }

}
