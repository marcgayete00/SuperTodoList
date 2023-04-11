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
import com.example.newtodolist.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private TextView banner;
    private EditText email;
    private EditText password;

    private TextView bannerRegister;
    private Button register;
    private Button login;

    //user: marc2
    //pass: marc123
    //email: rostided2@gmail.com

    public void registerDone(){
        Toast.makeText(this, "Register done!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TodoList.class);
        startActivity(intent);
    }

    public void showError(){
        Toast.makeText(this, "For some reason register failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        banner = findViewById(R.id.banner);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        bannerRegister = findViewById(R.id.bannerRegister);
        register = findViewById(R.id.loginIntent);

        login.setOnClickListener(v -> {

            FirebaseAuth mAuth = FirebaseAuth.getInstance();

            if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
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
                //Intent intent = new Intent(this, MainActivity.class);
                //startActivity(intent);
            }
        });


        register.setOnClickListener(v -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });
    }
}