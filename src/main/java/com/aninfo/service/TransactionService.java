package com.aninfo.service;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    public Transaction createTransaction(Transaction transaction, String transactionType, Long cbu, Double sum) {
        transaction.setType(transactionType);
        transaction.setCbuAccount(cbu);
        transaction.setSum(sum);

        accountService.addTransaction(transaction, transactionType, cbu, sum);
        return transactionRepository.save(transaction);
    }

    public void deleteById(Long numero) {
        transactionRepository.deleteById(numero);
    }

    public Optional<Transaction> findById(Long numero) { return transactionRepository.findById(numero);
    }

    public Collection<Transaction> getAccounts(Long cbu) {
        return transactionRepository.findAllByCbuAccount(cbu);

    }
}
