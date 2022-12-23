package com.example.loginmvvm12102022.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginmvvm12102022.data.local.entities.AccountEntity;
import com.example.loginmvvm12102022.data.repository.AuthenticationRepository;
import com.example.loginmvvm12102022.utils.interfaces.OnCallBackSignIn;

import kotlin.Triple;

/**
 * Created by pphat on 12/23/2022.
 */
public class MainViewModel extends ViewModel {
    private AuthenticationRepository repository;
    private MutableLiveData<AccountEntity> accountLiveData = new MutableLiveData<>();
    private MutableLiveData<String> messageLiveData = new MutableLiveData<>();

    public MainViewModel(AuthenticationRepository repository) {
        this.repository = repository;
    }

    public void signIn(String account, String password, Boolean isRemember) {
        repository.signIn(account, password, isRemember, new OnCallBackSignIn() {
            @Override
            public void onSuccess(Triple<String, String, Boolean> tripleAccount) {
                accountLiveData.setValue(
                        new AccountEntity(
                            tripleAccount.getFirst(),
                            tripleAccount.getSecond(),
                            tripleAccount.getThird()
                        )
                );
            }

            @Override
            public void onFail(String message) {
                messageLiveData.setValue(message);
            }
        });
    }
}
