package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

        final EditText nameET = (EditText) findViewById(R.id.name);
        final EditText numberET = (EditText) findViewById(R.id.numberEt);
        final EditText mailET = (EditText) findViewById(R.id.mail);
        final EditText passwd = (EditText) findViewById(R.id.passwordET);
        final EditText cPasswd = (EditText) findViewById(R.id.cPassword);


        Button signBTN = findViewById(R.id.sign_up_button);


        //Button backButton2 = findViewById(R.id.back2BTN);


        signBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dlg = new ProgressDialog(SignUpActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Returning to the login section...");
                dlg.show();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                dlg.dismiss();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });



        signBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                //Validating the log in data
                boolean validationError = false;

                StringBuilder validationErrorMessage = new StringBuilder("Please, insert ");
                if (isEmpty(nameET)) {
                    validationError = true;
                    validationErrorMessage.append("username");
                }
                if (isEmpty(numberET)) {
                    if (validationError) {
                        validationErrorMessage.append("Phone number");
                    }
                    validationError = true;
                    validationErrorMessage.append(" ");
                }
                if (isEmpty(mailET)) {
                    if (validationError) {
                        validationErrorMessage.append("Emailid");
                    }
                    validationError = true;
                    validationErrorMessage.append(" ");
                }
                if (isEmpty(passwd)) {
                    if (validationError) {
                        validationErrorMessage.append("Password");
                    }
                    validationError = true;
                    validationErrorMessage.append(" ");
                }
                if (isEmpty(cPasswd)) {
                    if (validationError) {
                        validationErrorMessage.append("  ");
                    }
                    validationError = true;
                    validationErrorMessage.append("Confirm Password");
                }

                validationErrorMessage.append(".");

                if (validationError) {
                    Toast.makeText(SignUpActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                //Setting up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(SignUpActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Signing up...");
                dlg.show();

                ParseUser user = new ParseUser();
                user.setUsername(nameET.getText().toString());
                user.setPassword(passwd.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            dlg.dismiss();
                            alertDisplayer("Sucessful Signup!", "Please Login " + nameET.getText().toString() + "!");

                        } else {
                            dlg.dismiss();
                            ParseUser.logOut();
                            Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });
    }

    private boolean isEmpty(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMatching(EditText text1, EditText text2){
        if(text1.getText().toString().equals(text2.getText().toString())){
            return true;
        }
        else{
            return false;
        }
    }

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }

    public void onBackClick(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
}


