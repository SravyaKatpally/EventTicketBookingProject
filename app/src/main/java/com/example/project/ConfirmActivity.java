
package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class ConfirmActivity extends EventActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_event);
        TextView tv = findViewById(R.id.confirmNumTV);
        Integer randomNum = ThreadLocalRandom.current().nextInt(1000000,1000000000);
        tv.setText("C" + randomNum.toString());
    }
    public void onBack(View view)
    {
        Intent intent = new Intent(this, EventActivity.class);
        startActivityForResult(intent,1);
    }

    public void onConfirm(View view)
    {
        Intent intent = new Intent(this, LastPageActivity.class);
        startActivityForResult(intent,1);
    }

    public void emailButton(View view)
    {
        Button b = findViewById(R.id.bookBTN);
        TextView tv = findViewById(R.id.emailTV);
        if(view == b)
        {
            tv.setText("Mail is sent");
        }

    }

}
