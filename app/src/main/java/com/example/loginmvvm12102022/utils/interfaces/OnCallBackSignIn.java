package com.example.loginmvvm12102022.utils.interfaces;

import kotlin.Triple;

public interface OnCallBackSignIn {
    void onSuccess(Triple<String, String, Boolean> tripleAccount);
    void onFail(String message);
}
