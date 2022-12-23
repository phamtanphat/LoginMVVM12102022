package com.example.loginmvvm12102022.presentation.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginmvvm12102022.R;
import com.example.loginmvvm12102022.data.local.entities.AccountEntity;
import com.example.loginmvvm12102022.data.repository.AuthenticationRepository;
import com.example.loginmvvm12102022.presentation.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtAccount, edtPassword;
    MainViewModel mainViewModel;
    AuthenticationRepository authenticationRepository;
    CheckBox ckIsRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authenticationRepository = new AuthenticationRepository(this);
        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(authenticationRepository);
            }
        }).get(MainViewModel.class);

        btnLogin = findViewById(R.id.button_login);
        edtAccount = findViewById(R.id.edit_text_account);
        edtPassword = findViewById(R.id.edit_text_password);
        ckIsRemember = findViewById(R.id.check_box_remember);

        mainViewModel.getAccount().observe(this, new Observer<AccountEntity>() {
            @Override
            public void onChanged(AccountEntity accountEntity) {
                if (accountEntity != null && accountEntity.isRemember) {
                    edtAccount.setText(accountEntity.account);
                    edtPassword.setText(accountEntity.password);
                    ckIsRemember.setChecked(accountEntity.isRemember);
                }
            }
        });

        mainViewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!s.isEmpty()) {
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainViewModel.checkRememberAccount();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = edtAccount.getText().toString();
                String password = edtPassword.getText().toString();
                boolean isRemember = ckIsRemember.isChecked();
                mainViewModel.signIn(account, password, isRemember);
            }
        });
    }
}
