package com.revature.registry.service;

import java.util.List;

import com.revature.registry.model.Account;
import com.revature.registry.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public Account getAccountByID(int id) {
        return accountRepo.findById(id).orElse(null);
    }
}
