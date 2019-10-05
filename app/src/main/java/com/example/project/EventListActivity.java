package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventListActivity extends SignUpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }

        public void bookTicket(View v)
        {
            Intent intent = new Intent(this, EventActivity.class);
            startActivityForResult(intent,1);
        }

    public void backButton(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,1);
    }
    }

