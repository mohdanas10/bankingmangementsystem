package com.bankingmangementsystemwithreact.bankingmangementsystem.Services;


import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Customer;
import com.bankingmangementsystemwithreact.bankingmangementsystem.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServices {
    @Autowired
    private CustomerRepo customerRepo;

    public String addCustomer(Customer customer ){
        this.customerRepo.save(customer);
        return "Customer sucessfully Added ";
    }
    public List<Customer> allCustomer (){
        return this.customerRepo.findAll();
    }

    public Customer customerById(int id ){
        return this.customerRepo.findById(id);
    }

    public String updateCustomer(int id , Customer customer){
        Customer upCustomer = this.customerRepo.findById(id);
        if(upCustomer.getId() == id ){
            upCustomer.setName(customer.getName());
            upCustomer.setAge(customer.getAge());
            upCustomer.setSex(customer.getSex());
            this.customerRepo.save(upCustomer);
        }
        return "customer update Successfully";
    }

    public void deleteCustomer(int id ){
        Customer customer = this.customerRepo.findById(id);
        this.customerRepo.delete(customer);

    }
    public int totalCustomer(){
        List<Customer> customers = this.customerRepo.findAll();
        return customers.size();
    }
}
