package com.bankingmangementsystemwithreact.bankingmangementsystem.Controller;

import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Transactions;
import com.bankingmangementsystemwithreact.bankingmangementsystem.Services.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://bankingmanagment.netlify.app")
@RestController
@RequestMapping("/customer")
public class TransactionsController {
    @Autowired
    private TransactionsServices transactionsServices;

    @PostMapping("/addTransactions")
    public Transactions addTransactions ( @RequestBody Transactions transactions){
        return  this.transactionsServices.addTransactions(transactions);
    }

    @GetMapping("/totalAmount/{id}")
    public double totalAmount(@PathVariable("id") int id ){
        return this.transactionsServices.totalAmount(id);
    }

    @PutMapping("/debitTransactions/{id}")
    public String debitTransactions (@PathVariable("id") int id , @RequestBody Transactions transactions){
        return  this.transactionsServices.debitTransactions(id, transactions);
    }

    @GetMapping("/searchCustomer/{id}")
    public String searchCustomer(@PathVariable("id") int id ){
        return  this.transactionsServices.searchCustomer(id);
    }

    @DeleteMapping("deleteTransactions/{id}")
    public void deleteTransactions(@PathVariable("id") int id ){
        this.transactionsServices.deleteTransactions( id );
    }

    @GetMapping("allTransactions/{id}")
    public List<Transactions> allTransactions(@PathVariable("id") int id ){
        return this.transactionsServices.allTransactions(id);
    }

    @GetMapping("/totalTransactionsAmount")
    public int totalTransactionsAmount() {
        return this.transactionsServices.totalTransactionsAmount();
    }

}
