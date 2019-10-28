
package com.example.project;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddingDeletingActivity extends AdminLoginActivity {

    public static int NAME1 =0;
    public static int DATE1 =1;
    public static int TIME1 =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_deleting_events);
    }



    public void onDelete(View view) {
        // Information of first delete
        TextView t1 = findViewById(R.id.textView15);
        TextView t2 = findViewById(R.id.textView2);
        TextView t3 = findViewById(R.id.textView);
        TextView t4 = findViewById(R.id.textView5);
        TextView nameTV = findViewById(R.id.nameTV);
        TextView dateTV = findViewById(R.id.dateTV);
        TextView timeET = findViewById(R.id.timeET);

        // Information of second delete
        TextView t5 = findViewById(R.id.textView7);
        TextView t6 = findViewById(R.id.textView21);
        TextView t7 = findViewById(R.id.textView24);

        Button b1 = findViewById(R.id.button4);
        Button b2 = findViewById(R.id.button5);
        Button b3 = findViewById(R.id.button6);

        if (b1 == view) {
            t2.setVisibility(view.INVISIBLE);
            t3.setVisibility(view.INVISIBLE);
            t4.setVisibility(view.INVISIBLE);
            b1.setVisibility(view.INVISIBLE);
        }
        if (b2 == view) {
            t5.setVisibility(view.INVISIBLE);
            t6.setVisibility(view.INVISIBLE);
            t7.setVisibility(view.INVISIBLE);
            b2.setVisibility(view.INVISIBLE);
        }
        if (b3 == view) {
            nameTV.setVisibility(view.INVISIBLE);
            dateTV.setVisibility(view.INVISIBLE);
            timeET.setVisibility(view.INVISIBLE);
            b3.setVisibility(view.INVISIBLE);
        }
    }

    public void onaddEvent(View v)
    {
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivityForResult(intent, 1);

    }

    public void onBackClick(View v)
    {
        Intent intent = new Intent(this, AdminLoginActivity.class);
        startActivityForResult(intent, 1);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode ==NAME1) {
            String v = data.getStringExtra("NAME1");
            String[] a = v.split(" ");


            TextView t = findViewById(R.id.nameTV);
            t.setText(a[0]);

            TextView t1 = findViewById(R.id.dateTV);
            t1.setText(a[1]);

            TextView t2 = findViewById(R.id.timeTV);
            t2.setText(a[2]);
        }
    }
}