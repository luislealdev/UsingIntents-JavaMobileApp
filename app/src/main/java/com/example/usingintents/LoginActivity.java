package com.example.usingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usingintents.models.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;
    private Button btnLogin;

    private final String USERNAME = "admin";
    private final String PASSWORD = "12345";

    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener((v) -> {
            validateUser(txtUsername.getText().toString(), txtPassword.getText().toString());
        });

        initUsers();
    }

    private void initUsers() {
        userList.add(new User(1, "user1", "12345", "Maya", "Arce", "maya_arce@gmail.com", "4611189202", "Av. 1", "http://facebook.com/maya_arce", "http://instagram.com/maya_arce", R.drawable.photo_1));
        userList.add(new User(2, "user2", "12345", "Ronald", "McGregory", "jhon_smith@gmail.com", "4611234782", "Av. 2", "http://facebook.com/jhon_smith", "http://instagram.com/jhon_smith", R.drawable.photo_2));
        userList.add(new User(3, "user3", "12345", "Dahyun", "Park", "dahyun_park@gmail.com", "4611290782", "Av. 3", "http://facebook.com/dahyun_park", "http://instagram.com/dahyun_park", R.drawable.photo_3));
        userList.add(new User(4, "user4", "12345", "Diego", "Gomez", "diego_gomez@gmail.com", "4611090702", "Av. 4", "http://facebook.com/diego_gomez", "http://instagram.com/diego_gomez", R.drawable.photo_4));
        userList.add(new User(5, "user5", "12345", "Harry", "Potter", "harry_potter@gmail.com", "4611090734", "Av. 5", "http://facebook.com/harry_potter", "http://instagram.com/harry_potter", R.drawable.photo_5));
    }

    private void validateUser(String username, String password) {
        AtomicBoolean userFound = new AtomicBoolean(false);
        userList.forEach((user) -> {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Intent intent = new Intent(this, MainActivity.class);
                userFound.set(true);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
        if(!userFound.get()) Toast.makeText(this, "Username not valid...", Toast.LENGTH_SHORT);
    }
/*
    private void validateUser(){
        String userName = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        if (userName.equals(USERNAME) && password.equals(PASSWORD)){
            Toast.makeText(this, "Valid user!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", userName);
            intent.putExtra("fullName","Isabel Vargas");
            intent.putExtra("email","21030072@itcelaya.edu.mx");
            startActivity(intent);
        } else {
            Toast.makeText(this, "User and/or password not valid", Toast.LENGTH_SHORT).show();
        }

    }
    */
}