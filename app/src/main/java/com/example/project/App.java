package com.example.project;

import android.app.Application;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseInstallation;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("LPKcRbTp0VuAIivhT2AmGov37Q5heTFO7gqpqiyK")
                // if defined
                .clientKey("GBcwTDAfm5x9Vzw8f5OV0iVbNVIMh9X341PwO8f3")
                .server("https://parseapi.back4app.com/")
                .build()
        );

         // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }
}
