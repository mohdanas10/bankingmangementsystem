package com.bankingmangementsystemwithreact.bankingmangementsystem.Services;

import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Transactions;
import com.bankingmangementsystemwithreact.bankingmangementsystem.Repository.TransactionRepo;
import jakarta.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TransactionsServices {
    @Autowired
    private TransactionRepo transactionRepo;

    public Transactions addTransactions( Transactions transactions){
        List<Transactions> ts = this.transactionRepo.findByTranId(transactions.getTranId());
        if(ts.size() == 0 ){
            transactions.setTotalAmount(transactions.getCreditAmount() + transactions.getTotalAmount());
            this.transactionRepo.save(transactions);
        }
        else {
            Transactions ts2 = ts.get(ts.size()- 1);
            transactions.setTotalAmount(ts2.getTotalAmount() + transactions.getCreditAmount());
            this.transactionRepo.save(transactions);
        }


        return transactions;
    }

    public double totalAmount(int id ){
        List<Transactions> transactions = this.transactionRepo.findByTranId(id);
        if(transactions.size() == 0){
            return 0;
        }
        else {
            return transactions.get(transactions.size() - 1).getTotalAmount();
        }
    }

    public String  debitTransactions(int id , Transactions transactions){
        List<Transactions> transactionsList = this.transactionRepo.findByTranId(id);
        if(transactionsList.size() == 0){
            return "No Balance !!";
        }
        else if(transactionsList.get(transactionsList.size()-1).getTotalAmount() < transactions.getDebitAmount()){
                return "Insuficient Balance !!";

        }
        else {
            transactions.setTotalAmount(transactionsList.get(transactionsList.size()- 1).getTotalAmount() - transactions.getDebitAmount());
            this.transactionRepo.save(transactions);
            return  null;
        }
    }

    public String searchCustomer(int id ){
        List<Transactions> transactions = this.transactionRepo.findByTranId(id);
       for(Transactions ts : transactions){
           if(ts.getTranId() == id){
               return "customer find";
           }
       }
       return "customer not found";

    }

    public void deleteTransactions(int id ){
        List<Transactions> transactionsList = this.transactionRepo.findByTranId(id);
        for(Transactions ts : transactionsList){
            this.transactionRepo.delete(ts);
        }
    }

    public List<Transactions> allTransactions(int id ){
        return  this.transactionRepo.findByTranId(id);
    }

    public int totalTransactionsAmount(){
        List<Transactions> transactions = this.transactionRepo.findAll();
        return transactions.size();
    }


}
