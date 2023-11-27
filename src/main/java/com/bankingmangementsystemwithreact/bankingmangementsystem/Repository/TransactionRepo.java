package com.bankingmangementsystemwithreact.bankingmangementsystem.Repository;

import com.bankingmangementsystemwithreact.bankingmangementsystem.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Integer> {

    public List<Transactions> findByTranId(int id);

}
