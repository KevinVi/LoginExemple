package com.exemple.loginexemple;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.exemple.loginexemple.Model.Data;
import com.exemple.loginexemple.Model.JsonParser;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getListFromServer();
    }
    public void getListFromServer(){
        Ion.with(getApplicationContext())
                .load(getString(R.string.pathContents))
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        if (e != null) {
                            //      Log.i("e!null", "here");
                               Log.e("Error Selections REST", e.getMessage());
                        } else {
                            String json = result.toString();
                            ArrayList<Data> videos = JsonParser.listFromJson(json, getApplicationContext());
                            if (videos != null) {
                                goToMain();
                            }

                        }
                    }
                });
    }
    public void goToMain() {

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
