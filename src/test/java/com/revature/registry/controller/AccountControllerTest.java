package com.revature.registry.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.revature.registry.AccountMicroServiceApplication;
import com.revature.registry.model.Account;
import com.revature.registry.service.AccountService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = AccountMicroServiceApplication.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Autowired
    @InjectMocks
    private AccountController accountController;

    Account acc1;
    Account acc2;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        acc1 = new Account();
        acc2 = new Account();
        acc1.setId(1);
        acc2.setId(2);
        List<Account> accs = new ArrayList<Account>() {
            {
                add(acc1);
                add(acc2);
            }
        };
        when(accountService.getAllAccounts()).thenReturn(accs);
        when(accountService.getAccountByID(acc1.getId())).thenReturn(acc1);
    }

    @Test
    void testGetAllAccounts() throws Exception {
        mockMvc.perform(get("/api/account")).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(List.class)))
                .andExpect(jsonPath("$[0].id").value(acc1.getId())).andExpect(jsonPath("$[1].id").value(acc2.getId()));
    }

    @Test
    void testGetAccountByID() throws Exception {
        mockMvc.perform(get("/api/account/id/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(acc1.getId()));
    }
}
