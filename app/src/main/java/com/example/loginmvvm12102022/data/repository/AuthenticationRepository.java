package com.example.loginmvvm12102022.data.repository;

import android.content.Context;

import com.example.loginmvvm12102022.data.local.entities.AccountEntity;
import com.example.loginmvvm12102022.data.local.sharepref.MySharePref;
import com.example.loginmvvm12102022.utils.interfaces.OnCallBackSignIn;

import kotlin.Triple;

/**
 * Created by pphat on 12/23/2022.
 */
public class AuthenticationRepository {
    private MySharePref mySharePref;

    public AuthenticationRepository(Context context) {
        mySharePref = MySharePref.getInstance(context);
    }

    public void signIn(String account, String password, boolean isRemember, OnCallBackSignIn onCallBackSignIn) {
        if (account.equals("phat") && password.equals("123")) {
            Triple<String, String, Boolean> triple = new Triple<>(account, password, isRemember);
            mySharePref.saveAccount(triple);
            onCallBackSignIn.onSuccess(triple);
            return;
        }
        onCallBackSignIn.onFail("Tài khoản không chính xác");
    }

    public AccountEntity getAccountIsRemember() {
        Triple<String, String, Boolean> tripleAccount = mySharePref.getAccountIsRemember();
        if (tripleAccount != null) {
            return new AccountEntity(tripleAccount.getFirst(), tripleAccount.getSecond(), tripleAccount.getThird());
        }
        return null;
    }
}
