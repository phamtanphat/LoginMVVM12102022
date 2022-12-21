package com.example.loginmvvm12102022.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginmvvm12102022.R;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtAccount, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.button_login);
        edtAccount = findViewById(R.id.edit_text_account);
        edtPassword = findViewById(R.id.edit_text_password);
    }
}
