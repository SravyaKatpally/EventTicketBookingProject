package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onBackClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,1);
    }

    public void signup(View v)
    {
        EditText et9 = findViewById(R.id.editText9);
        EditText et10 = findViewById(R.id.editText9);
        EditText et13 = findViewById(R.id.editText9);
        EditText et5 = findViewById(R.id.editText9);
        EditText et12 = findViewById(R.id.editText9);
        TextView tv18 = findViewById(R.id.textView18);


        if(et5.getText().toString() == et12.getText().toString())
        {

            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent,1);
        }
        else
        {

            tv18.setText("Password Match Error");
        }
    }
}
