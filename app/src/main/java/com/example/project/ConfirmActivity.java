
package com.example.project;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSignUp(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivityForResult(intent,1);
    }

    public void onAdminLogin(View view)
    {
        Intent intent = new Intent(this, AdminLoginActivity.class);
        startActivityForResult(intent,1);
    }
}
