package com.example.loginmvvm12102022.data.local.sharepref;

import android.content.Context;
import android.content.SharedPreferences;

import kotlin.Triple;

/**
 * Created by pphat on 12/21/2022.
 */
public class MySharePref {
    private static MySharePref instance = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private MySharePref(Context context) {
        sharedPreferences = context.getSharedPreferences("My_cache", Context.MODE_PRIVATE);
    }

    public static MySharePref getInstance(Context context) {
        if (instance == null) {
            instance = new MySharePref(context);
        }
        return instance;
    }

    public void saveAccount(Triple<String, String, Boolean> triple) {
        editor = sharedPreferences.edit();
        editor.putString("account", triple.getFirst());
        editor.putString("password", triple.getSecond());
        editor.putBoolean("isRemember", triple.getThird());
        editor.commit();
    }

    public Triple<String, String, Boolean> getAccount() {
        String account = sharedPreferences.getString("account", "");
        String password = sharedPreferences.getString("password", "");
        Boolean isRemember = sharedPreferences.getBoolean("isRemember", false);
        return new Triple<>(account, password, isRemember);
    }
}
