package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button sign_action_button = findViewById(R.id.sign_up_button);
        sign_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = findViewById(R.id.name);
                final EditText mail = findViewById(R.id.mail);
                EditText mobile = findViewById(R.id.numberEt);
                EditText password = findViewById(R.id.passwordET);

                final ParseUser sing_up_user = new ParseUser();
                sing_up_user.setEmail(mail.getText().toString());
                sing_up_user.setPassword(password.getText().toString());
                sing_up_user.setUsername(name.getText().toString());
                sing_up_user.put("Mobile",(mobile.getText().toString()));
                sing_up_user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //dlg.dismiss();
                            alertDisplayer("Sucessful Signup","Successfully signed up " + mail.getText().toString() + "!");

                        } else {
                            //dlg.dismiss();
                            ParseUser.logOut();
                            Toast.makeText(SignUpActivity.this, "error message", Toast.LENGTH_LONG).show();
                            Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


    }

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
//                        Intent intent = new Intent(SignUpActivity.this, MainScreen.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
                        Toast.makeText(SignUpActivity.this, "Succesfully created user account", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }

    public void onBackClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,1);
    }

    public void signup(View v) {
        EditText num = findViewById(R.id.numberEt);
        EditText name = findViewById(R.id.name);
        EditText mail = findViewById(R.id.mail);
        EditText psw = findViewById(R.id.passwordET);
        EditText cpsw = findViewById(R.id.cPassword);
        TextView tv18 = findViewById(R.id.textView18);
        if (!name.getText().toString().isEmpty() ||
                !name.getText().toString().isEmpty() ||
                !name.getText().toString().isEmpty() ||
                !name.getText().toString().isEmpty() ||
                !name.getText().toString().isEmpty() )
        {
            if((psw.getText().toString().length()==8) && (cpsw.getText().toString().length()==8))
            {
                if(psw.getText().toString().equalsIgnoreCase(cpsw.getText().toString()))
                {
                    if(mail.getText().toString().contains("@"))
                    {
                        if(num.getText().toString().length()==10)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "SignUp Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivityForResult(intent, 1);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),
                                    "Enter 10 digits phone number", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),
                                "Enter valid email id", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Your password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Your password should be of 8 characters length", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Enter all the Fields", Toast.LENGTH_SHORT).show();
        }
    }
}
