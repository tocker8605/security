package com.tocker.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="account")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name="user_key", nullable=false, length=64, unique=true)
    String userKey;

    @Column(name="auth", nullable=false, length=128)
    String auth;

    @Column(name="role", nullable=false, length=64)
    String role;

    @Column(name="sns_type", length=12)
    String snsType;

    @Column(name="sns_id", length=64)
    String snsId;

}
