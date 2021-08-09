package com.revature.registry.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.registry.AccountMicroServiceApplication;
import com.revature.registry.model.Account;
import com.revature.registry.repository.AccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = AccountMicroServiceApplication.class)
@ExtendWith(SpringExtension.class)
class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepo;

    Account acc1;
    Account acc2;
    List<Account> accs;

    @BeforeEach
    void init() {
        acc1 = new Account();
        acc2 = new Account();
        acc1.setId(1);
        acc2.setId(2);
        accs = new ArrayList<Account>() {
            {
                add(acc1);
                add(acc2);
            }
        };
        when(accountRepo.findAll()).thenReturn(accs);
        when(accountRepo.findById(acc1.getId())).thenReturn(Optional.ofNullable(acc1));
        when(accountRepo.findById(acc2.getId())).thenReturn(Optional.ofNullable(acc2));
    }

    @Test
    void testGetAllAccounts() {
        assertEquals(accountService.getAllAccounts().size(), accs.size());
    }

    @Test
    void testGetAccountByID() {
        assertEquals(accountService.getAccountByID(1), acc1);
    }
}
