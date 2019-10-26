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

    public void signup(View v) {
        EditText num = findViewById(R.id.numberEt);
        EditText name = findViewById(R.id.name);
        EditText mail = findViewById(R.id.mail);
        EditText psw = findViewById(R.id.passwordET);
        psw.setText("abc");
        EditText cpsw = findViewById(R.id.cPassword);
        cpsw.setText("abc");
        TextView tv18 = findViewById(R.id.textView18);

        if(psw.getText().toString().equals("abc"))
        {

            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent, 1);
        }
        else
        {
            tv18.setText("Password Match Error");
        }
    }
}
