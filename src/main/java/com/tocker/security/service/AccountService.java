package com.tocker.security.service;

import com.tocker.security.domain.Account;
import com.tocker.security.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account getAccountByUserKey(String userKey) {
        return accountRepository.findByUserKey(userKey);
    }

    public Account getAccountByOAuthId(String type, String id) {
        return accountRepository.findByOAuthId(type, id);
    }

}
