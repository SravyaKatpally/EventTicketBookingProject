
package com.example.project;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class AddingDeletingActivity extends AdminLoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_deleting_events);
    }

    public void onAddEvent(View view)
    {
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivityForResult(intent,1);
    }

    public void onDelete(View view)
    {
        TextView t1 = findViewById(R.id.textView15);
        Button b1 = findViewById(R.id.button4);
        Button b2 = findViewById(R.id.button4);
        if(b1 == view )
        {
            t1.setText("Event gets deleted");
        }
        if(b2 == view )
        {
            t1.setText("Event gets deleted");
        }

    }

}
