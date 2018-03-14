package com.example.opilane.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuthException;

public class LoginActivity extends AppCompatActivity {

    EditText epost, salasõna;
    Button btn_login;
    TextView registreeri, unustatud, katse;

    int loendaja = 3;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        epost = findViewById(R.id.epost);
        salasõna = findViewById(R.id.password);
        btn_login = findViewById(R.id.btnlogin);
        registreeri = findViewById(R.id.registreeri);
        unustatud = findViewById(R.id.unustatud);
        katse = findViewById(R.id.katse);

    }
}
