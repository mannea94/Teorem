package com.example.manne.json.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.manne.json.Models.User;
import com.example.manne.json.R;
import com.example.manne.json.SharedPreferences;

public class StartActivity extends AppCompatActivity {

    User user;
    String userID="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        user=new User();

        user= SharedPreferences.getUser(this);

        userID=SharedPreferences.getUserID(this);
        Handler runnable = new Handler();
        runnable.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user!=null && user.getUsername()!=null){
                    Intent intent = new Intent(StartActivity.this, MainFragmentsActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(StartActivity.this, FirstActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
