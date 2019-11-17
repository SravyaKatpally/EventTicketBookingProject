package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity {
    public static int NAME1 = 0;

    private String name1 = "";
    private String date1 = "";
    private String time1 = "";

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


    }

    

    public void onReturnLogin(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);
    }

    public void addEventClick(View v)
    {
        EditText et = findViewById(R.id.eevntNameET);
        String name1 = et.getText().toString();

        EditText et1 = findViewById(R.id.adminDateET);
        String date1 = et1.getText().toString();

        EditText et2 = findViewById(R.id.timeET);
        String time1 = et2.getText().toString();

        String main = name1 +" "+date1 +" "+time1;
        Intent i = new Intent();
        i.putExtra("NAME1",main);
        setResult(AddingDeletingActivity.NAME1,i);
        finish();
    }
}
