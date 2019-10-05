package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void onConfirm(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,1);
    }

    public void onClick(View view)
    {
        TextView t1 = findViewById(R.id.textView17);
        Button b1 = findViewById(R.id.button) ;
        if(view == b1)
        {
            t1.setText(" Confirmed ");
        }

    }
}
