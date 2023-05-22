package com.aninfo.service;
import com.aninfo.exceptions.InvalidCbuException;
import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction, AccountService accountService) {
        Optional<Account> accountOptional = accountService.findById(transaction.getCbuAccount());

        if (!accountOptional.isPresent()) {
            throw new InvalidCbuException("Cbu provided does not exist");
        }

        if(Objects.equals(transaction.getType(), "deposit")){
            accountService.deposit(transaction.getCbuAccount(), transaction.getSum());
        } else if(Objects.equals(transaction.getType(), "withdraw")){
            accountService.withdraw(transaction.getCbuAccount(), transaction.getSum());
        } else {
            throw new InvalidTransactionTypeException("Invalid transaction type");
        }

        return transactionRepository.save(transaction);
    }

    public void deleteById(Long numero) {
        transactionRepository.deleteById(numero);
    }

    public Optional<Transaction> findById(Long numero) { return transactionRepository.findById(numero);
    }

    public Collection<Transaction> getTransactions(Long cbu) {
        return transactionRepository.findAllByCbuAccount(cbu);
    }
}
