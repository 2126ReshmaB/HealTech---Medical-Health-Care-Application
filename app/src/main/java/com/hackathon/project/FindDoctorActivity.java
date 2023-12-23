package com.hackathon.project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class FindDoctorActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView pid = findViewById(R.id.pedia);
        pid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","pediatrician");
                startActivity(it);
            }
        });
        setSupportActionBar(toolbar);

            toolbar = findViewById(R.id.toolbar);
            drawerLayout = findViewById(R.id.drawer);

            actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(actionBarDrawerToggle.onOptionsItemSelected(item)){
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }


