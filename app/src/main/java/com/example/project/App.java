package com.example.project;

import android.app.Application;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseInstallation;


public class   App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RaNjb9jVBufoBL7eB4esGGoqU4b4NXk4IyG7rhWA")
                // if defined
                .clientKey("04KSrPS3k5juTNLBjz58HjDMjR1wdLl9OE29gr2p")
                .server(getString(R.string.back4app_server_url))
                .build()
        );

         // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }
}
