package com.example.opilane.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText eesNimi, pereNimi, epost, salasõna;
    Button btnregister;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    String _eesnimi, _perenimi, _epost, _salasõna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eesNimi = findViewById(R.id.eesNimi);
        pereNimi = findViewById(R.id.pereNimi);
        epost = findViewById(R.id.epost);
        salasõna = findViewById(R.id.password);
        btnregister = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private boolean valideeri(){
        boolean tulemus = false;
        _eesnimi = eesNimi.getText().toString();
        _perenimi = pereNimi.getText().toString();
        _epost = epost.getText().toString();
        _salasõna = salasõna.getText().toString();

        if (_eesnimi.isEmpty() || _perenimi.isEmpty() || _epost.isEmpty() || _salasõna.isEmpty()){
            teade("Täida kõik väljad!");
        }
        else {
            tulemus = true;
        }
        return tulemus;
    }
    private void saadaEpostiKinnitus(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                       saadaKasutajaAndmed();
                       teade("Registreerimine õnnestus, teile saadeti kinnitus email!");
                       finish();
                       startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else {
                        teade("Kinnitus emaili ei saadetud!");
                    }

                }
            });
        }
    }

    public void teade(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
