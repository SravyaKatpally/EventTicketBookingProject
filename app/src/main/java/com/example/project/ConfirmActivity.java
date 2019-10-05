
package com.example.project;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

public class ConfirmActivity extends EventActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_event);
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

}
