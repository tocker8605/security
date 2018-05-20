package com.tocker.security.auth;

import com.tocker.security.domain.Account;
import com.tocker.security.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private AccountService accountService;

    @Autowired
    public MyUserDetailService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public MyUserDetails loadUserByUsername(String userKey) throws UsernameNotFoundException {
        Account account = accountService.getAccountByUserKey(userKey);

        if (account == null) {
            throw new UsernameNotFoundException("그런 유저 없는데요");
        }

        return new MyUserDetails(account);
    }
}
