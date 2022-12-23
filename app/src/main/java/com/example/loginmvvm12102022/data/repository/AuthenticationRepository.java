package com.example.loginmvvm12102022.data.repository;

import com.example.loginmvvm12102022.data.local.entities.AccountEntity;
import com.example.loginmvvm12102022.data.local.sharepref.MySharePref;

import kotlin.Triple;

/**
 * Created by pphat on 12/23/2022.
 */
public class AuthenticationRepository {
    private MySharePref mySharePref;

    public void signIn(String account, String password, boolean isRemember) {
        if (account.equals("phat") && password.equals("123")) {
            mySharePref.saveAccount(new Triple<>(account, password, isRemember));
        }
    }

    public AccountEntity getAccountIsRemember() {
        Triple<String, String, Boolean> tripleAccount = mySharePref.getAccountIsRemember();
        if (tripleAccount != null) {
            return new AccountEntity(tripleAccount.getFirst(), tripleAccount.getSecond(), tripleAccount.getThird());
        }
        return null;
    }
}
