package com.hackathon.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextAppFullName);
        edPassword = findViewById(R.id.editTextAppContact);
        edEmail = findViewById(R.id.editTextAppAddress);
        edConfirm = findViewById(R.id.editTextAppFees);
        btn = findViewById(R.id.buttonBookAppoinment);
        tv = findViewById(R.id.textViewNewUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                DataBase db = new DataBase(getApplicationContext(),"chill-out",null,1);
                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm) == 0) {
                        if(isValid(password)){
                            db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    }
                    else{
                            Toast.makeText(getApplicationContext(), "password must contain at least 8 characters,having letters , digits and some special characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String password){
        int f1 = 0,f2 = 0,f3 = 0;
        if(password.length() < 8){
            return false;
        }
        else{
            for(int i = 0;i < password.length();i ++) {
                if (Character.isLetter(password.charAt(i))) {
                    f1 = 1;
                }
            }
            for(int i = 0;i < password.length();i ++) {
                if (Character.isDigit(password.charAt(i))) {
                    f2 = 1;
                }
            }
            for(int i = 0;i < password.length();i ++) {
                char ch = password.charAt(i);
                if(ch>=33 && ch <= 46 || ch==64){
                    f3=1;
            }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
        }
        return false;
    }

}