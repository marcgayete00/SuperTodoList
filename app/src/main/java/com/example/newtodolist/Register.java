package com.example.newtodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.example.newtodolist.R;


public class Register extends AppCompatActivity {

    private TextView registerBanner;
    private EditText username;
    private EditText password;
    private EditText email;

    private Button registerButton;

    private TextView loginBanner;

    private Button loginButton;

    public void registerDone(){
        Toast.makeText(this, "Register done!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void showError(){
        Toast.makeText(this, "For some reason register failed!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBanner = findViewById(R.id.registerBanner);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        registerButton = findViewById(R.id.registerButton);
        loginBanner = findViewById(R.id.loginBanner);
        loginButton = findViewById(R.id.loginIntent);

        registerButton.setOnClickListener(v -> {

            FirebaseAuth mAuth = FirebaseAuth.getInstance();

            if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(email.getText().toString())) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }else if(password.getText().length() < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    registerDone();
                                } else {
                                    showError();
                                }
                            }
                        });
                }
        });

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });

    }
}