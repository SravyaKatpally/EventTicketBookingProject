package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventListActivity extends EventActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }

    public void bookTicketFootball(View v)
    {
        Intent intent = new Intent(this, EventActivity.class);
        startActivityForResult(intent,1);
    }
    public void backButton(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,1);
    }

    public void bookTicketCricket(View v)
    {
        Intent intent = new Intent(this, CricketEventActivity.class);
        startActivityForResult(intent,1);
    }
}



