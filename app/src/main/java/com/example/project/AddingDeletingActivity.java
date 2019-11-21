
package com.example.project;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddingDeletingActivity extends AdminLoginActivity {

    public static int NAME1 =0;
    private String name = "abc";
    private String date1 = "";
    private String time1 = "";
    public static final int login = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_deleting_events);

        SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
        name= sharedData.getString("nameText", "abc");

        Button b1 = findViewById(R.id.thirdBook);
        Button b2 = findViewById(R.id.thirdDelete);

        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);

        Button bb1 = findViewById(R.id.fd2);
        Button bb2 = findViewById(R.id.delete2);
        Button bb3 = findViewById(R.id.thirdDelete);

        bb1.setVisibility(View.INVISIBLE);
        bb2.setVisibility(View.INVISIBLE);
        bb3.setVisibility(View.INVISIBLE);
    }

    public void onDelete(View view)
    {
        // Information of first delete
        TextView t1 = findViewById(R.id.e1);
        TextView t2 = findViewById(R.id.d1);
        TextView t3 = findViewById(R.id.text1);
        Button b1 = findViewById(R.id.book1);
        Button b2 = findViewById(R.id.fd2);

        TextView t20 = findViewById(R.id.e2);
        TextView t21 = findViewById(R.id.date2);
        TextView t22 = findViewById(R.id.time2);
        Button b3 = findViewById(R.id.book2);
        Button b4 = findViewById(R.id.delete2);

        TextView t30 = findViewById(R.id.thirdEvent);
        TextView t31 = findViewById(R.id.thirdDate);
        TextView t32 = findViewById(R.id.thirdTime);
        Button b5 = findViewById(R.id.thirdBook);
        Button b6 = findViewById(R.id.thirdDelete);

        if (b2 == view) {
            t1.setVisibility(view.INVISIBLE);
            t2.setVisibility(view.INVISIBLE);
            t3.setVisibility(view.INVISIBLE);
            b1.setVisibility(view.INVISIBLE);
            b2.setVisibility(view.INVISIBLE);
        }
        if (b4 == view) {
            t20.setVisibility(view.INVISIBLE);
            t21.setVisibility(view.INVISIBLE);
            t22.setVisibility(view.INVISIBLE);
            b3.setVisibility(view.INVISIBLE);
            b4.setVisibility(view.INVISIBLE);
        }
        if (b6 == view) {
            t30.setVisibility(view.INVISIBLE);
            t31.setVisibility(view.INVISIBLE);
            t32.setVisibility(view.INVISIBLE);
            b5.setVisibility(view.INVISIBLE);
            b6.setVisibility(view.INVISIBLE);
        }
    }

    public void onaddEvent(View v)
    {
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivityForResult(intent, 1);
        Button b1 = findViewById(R.id.thirdBook);
        Button b2 = findViewById(R.id.thirdDelete);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
    }

    public void onBookFootball(View v)
    {
        Intent intent = new Intent(this, AdminFootBallBookActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onBookCricket(View v)
    {
        Intent intent = new Intent(this, AdminCricketBookActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onBackClick(View v)
    {
        Intent intent = new Intent(this, AdminLoginActivity.class);
        startActivityForResult(intent, 1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode == login)
        {
            Button b = findViewById(R.id.addevent);
            b.setVisibility(View.INVISIBLE);
        }
        if (resultCode == NAME1) {
            SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
            name = sharedData.getString("nameText", name);

            Button bb1 = findViewById(R.id.fd2);
            Button bb2 = findViewById(R.id.delete2);
            Button bb3 = findViewById(R.id.thirdDelete);

            String v = data.getStringExtra("NAME1");
            String[] a = v.split(" ");
            name= a[0];
            SharedPreferences.Editor editor = sharedData.edit();
            editor.putString("nameText", name);
            Log.d("added", "sharedPREFERENCE");
            editor.commit();

            TextView nameText = findViewById(R.id.thirdEvent);
            nameText.setText(name);

            TextView t1 = findViewById(R.id.thirdDate);
            date1 = a[1];
            t1.setText(date1);

            TextView t2 = findViewById(R.id.thirdTime);
            time1 = a[2];
            t2.setText(time1);

            bb1.setVisibility(View.VISIBLE);
            bb2.setVisibility(View.VISIBLE);
            bb3.setVisibility(View.VISIBLE);
        }
    }

    public void confirmEvent(View v)
    {

        SharedPreferences sharedData = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedData.edit();
        name = sharedData.getString("nameText", "abc");

        sharedEditor.putString("nameText",name);
        sharedEditor.commit();

        if(sharedEditor.equals(null))
        {
            Toast.makeText(getApplicationContext(), "not added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Confirmed", Toast.LENGTH_SHORT).show();
        }


    }
}