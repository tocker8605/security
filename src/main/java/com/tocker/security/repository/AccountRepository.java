package com.tocker.security.repository;

import com.tocker.security.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT account FROM Account account WHERE account.userKey = lower(:userKey)")
    Account findByUserKey(@Param("userKey") String userKey);

    @Query("SELECT account FROM Account account WHERE account.snsType = :snsType AND account.snsId = :snsId")
    Account findByOAuthId(@Param("snsType") String snsType, @Param("snsId") String snsId);

}
