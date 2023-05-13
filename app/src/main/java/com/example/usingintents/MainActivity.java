package com.example.usingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.usingintents.models.User;

public class MainActivity extends AppCompatActivity {

    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWelcome = findViewById(R.id.txtWelcome);

        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.getSerializable("user");
        txtWelcome.setText("Welcome " + user.getFirstName() + ", enjoy this app...");
    }
}