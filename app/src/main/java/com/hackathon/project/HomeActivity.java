package com.hackathon.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "WelCome" + username, Toast.LENGTH_SHORT).show();
        btn = findViewById(R.id.button3);
        btn1 = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,DoctorAppW.class));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FirstAidActivity.class));
            }
        });


    }
}