package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class AdminCricketBookActivity extends AppCompatActivity {


    private Integer a = 50;
    String h = "";
    public static int EVENTNAME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cricket_book_event);

        SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
        a = sharedData.getInt("data", 0);
        TextView vv = findViewById(R.id.numTicketsTV);
        vv.setText(a.toString());
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
                    //Integer a =0;
                    a = oo - c;


                    SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedData.edit();

                    editor.putInt("data", a);
                    editor.commit();


                    //SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
                    //a = sharedData.getInt("data", 0);


                    //numTicket.setText(a.toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onConfirm(View view) {

        SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedData.edit();
        a = sharedData.getInt("data", 0);



        TextView numOfTickets = findViewById(R.id.bookedTV);
        if(Integer.parseInt(numOfTickets.getText().toString()) == 0)
        {
            Toast.makeText(getApplicationContext(),
                    "Select num of tickets",Toast.LENGTH_SHORT).show();
        }
        else
        {
            TextView ll = findViewById(R.id.numTicketsTV);
            ll.setText(a.toString());

            //Intent intent = new Intent(this, ConfirmActivity.class);
            //startActivityForResult(intent, 1);
        }

        sharedEditor.putInt("data",a);
        sharedEditor.commit();
    }


    public void onBack(View view) {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivityForResult(intent, 1);
    }


    public void onReset(View v)
    {
        Integer b = 50;
        TextView vv = findViewById(R.id.numTicketsTV);
        vv.setText(b.toString());
    }
}
