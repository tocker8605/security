package com.tocker.security.auth;

import com.tocker.security.domain.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper=false)
@Getter
public class MyUserDetails extends User {

    private String userName;

    public MyUserDetails(Account account) {
        super(
            account.getUserKey(),
            account.getAuth(),
            getAuthorities(account.getRole())
        );

        userName = account.getUserKey();
    }

    public static List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> list = new ArrayList<>();

        list.add(new SimpleGrantedAuthority(RoleType.USER.toString()));

//        if (role != null) {
//            list.add(new SimpleGrantedAuthority(role));
//        }

        return list;
    }

}
