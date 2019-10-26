package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignUp(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivityForResult(intent,1);
    }

   // public void login(View view)
    //{
      //  Intent intent = new Intent(this, EventListActivity.class);
        // startActivityForResult(intent,1);
   // }


    public void onAdminLogin(View view)
    {
        Intent intent = new Intent(this, AdminLoginActivity.class);
        startActivityForResult(intent,1);
    }

    public static final int login = 0;


    public void onLogin(View v) {

        EditText username = (EditText)findViewById(R.id.userET);
        EditText password = (EditText)findViewById(R.id.passwordET);

        if(username.getText().toString().equals("user1") && password.getText().toString().equals("1111")||
                username.getText().toString().equals("user2") && password.getText().toString().equals("9999"))
        {
            Toast.makeText(getApplicationContext(),
                    "Successfully logged in",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,EventListActivity.class);
            startActivityForResult(intent,login);
        }
        else {

            Toast.makeText(getApplicationContext(), "Enter Valid Credentials", Toast.LENGTH_SHORT).show();
        }
    }

}
