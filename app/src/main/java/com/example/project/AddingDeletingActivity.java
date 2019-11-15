
package com.example.project;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        if(resultCode ==NAME1) {
            String v = data.getStringExtra("NAME1");
            String[] a = v.split(" ");


            TextView t = findViewById(R.id.thirdEvent);
            t.setText(a[0]);

            TextView t1 = findViewById(R.id.thirdDate);
            t1.setText(a[1]);

            TextView t2 = findViewById(R.id.thirdTime);
            t2.setText(a[2]);
        }
    }
}