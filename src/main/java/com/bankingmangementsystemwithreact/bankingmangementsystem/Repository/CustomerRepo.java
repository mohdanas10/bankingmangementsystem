package com.bankingmangementsystemwithreact.bankingmangementsystem.Repository;

import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer > {
    public Customer findById(int id );
}
