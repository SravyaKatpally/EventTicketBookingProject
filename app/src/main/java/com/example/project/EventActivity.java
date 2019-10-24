package com.example.project;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.util.ArrayList;
        import java.util.concurrent.ThreadLocalRandom;

public class EventActivity extends EventListActivity {
    //String h ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);

        String[] arraySpinner = new String[]{
                "1", "2", "3", "4", "5"
        };
        Spinner s = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


    }


    public void onConfirm(View view)
    {
        Intent intent = new Intent(this, ConfirmActivity.class);
        startActivityForResult(intent,1);




    }

    public void onBack(View view)
    {
        Intent intent = new Intent(this, EventListActivity.class);
        startActivityForResult(intent,1);
    }



}
