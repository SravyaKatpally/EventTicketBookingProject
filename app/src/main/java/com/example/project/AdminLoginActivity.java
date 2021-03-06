package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }

    public void onAdminBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);
    }

    public static final int login = 0;

    //public void onLogin(View view) {
    // Intent intent = new Intent(this, AddingDeletingActivity.class);
    // startActivityForResult(intent, 1);
    // }

    public void onLogin(View v) {

        EditText username = (EditText)findViewById(R.id.adminusernameET);
        EditText password = (EditText)findViewById(R.id.adminpasswordET);

        if(username.getText().toString().equals("Admin") && password.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(),
                    "Successfully logged in",Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(this,AddingDeletingActivity.class);
            startActivityForResult(intent,login);
        }
        else {

            Toast.makeText(getApplicationContext(), "Enter Valid Credentials", Toast.LENGTH_SHORT).show();
        }
    }

}

