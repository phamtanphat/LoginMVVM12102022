package com.example.loginmvvm12102022.data.local.entities;

/**
 * Created by pphat on 12/23/2022.
 */
public class AccountEntity {
    public String account;
    public String password;
    public boolean isRemember;

    public AccountEntity(String account, String password, boolean isRemember) {
        this.account = account;
        this.password = password;
        this.isRemember = isRemember;
    }

    public AccountEntity() {}
}
