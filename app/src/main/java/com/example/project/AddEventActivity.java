package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddEventActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void onConfirm(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("mylist", list);
        startActivityForResult(intent,1);
    }

    public void onClick(View view)
    {
       /* EditText editText1 = findViewById(R.id.editText2);
        EditText editText2 = findViewById(R.id.editText4);
        EditText editText3 = findViewById(R.id.numTicketsTV);

        list.add(1,editText1.getText().toString());
        list.add(2,editText2.getText().toString());
        list.add(3,editText3.getText().toString());

        Intent intent = new Intent(this, AddingDeletingActivity.class);
       // intent.putExtra("mylist", list);
        startActivityForResult(intent,1);
*/


        TextView t1 = findViewById(R.id.textView17);
        Button b1 = findViewById(R.id.button) ;
        if(view == b1)
        {
            t1.setText(" Confirmed ");
        }

    }


}
