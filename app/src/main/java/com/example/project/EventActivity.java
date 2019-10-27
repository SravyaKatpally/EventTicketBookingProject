package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EventActivity extends AppCompatActivity {
    String h = "";
    public static int EVENTNAME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);

        String[] arraySpinner = new String[]{
                "0", "1", "2", "3", "4", "5"
        };
        Spinner s = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner s = findViewById(R.id.spinner);
                TextView o = findViewById(R.id.bookedTV);
                o.setText(s.getSelectedItem().toString());
                if(Integer.parseInt(o.getText().toString()) ==0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Select num of tickets",Toast.LENGTH_SHORT).show();
                }
                else {

                    TextView numTicket = findViewById(R.id.numTicketsTV);
                    Integer oo = Integer.parseInt(numTicket.getText().toString());
                    TextView numOfTickets = findViewById(R.id.bookedTV);
                    Integer c = Integer.parseInt(numOfTickets.getText().toString());
                    Integer a = oo - c;
                    numTicket.setText(a.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onConfirm(View view) {
        TextView numOfTickets = findViewById(R.id.bookedTV);
        if(Integer.parseInt(numOfTickets.getText().toString()) == 0)
        {
            Toast.makeText(getApplicationContext(),
                    "Select num of tickets",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, ConfirmActivity.class);
            startActivityForResult(intent, 1);
        }
        }


    public void onBack(View view) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == EVENTNAME)
        {
            String intentData = data.getStringExtra("EVENTNAME");
            TextView tv = findViewById(R.id.displayTV);
            tv.setText("lslhseilglfck "+intentData);
        }
    }
}
