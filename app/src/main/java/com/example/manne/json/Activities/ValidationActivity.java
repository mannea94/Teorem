package com.example.manne.json.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.manne.json.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ValidationActivity extends AppCompatActivity {

    @BindView(R.id.switchBar)
    Switch aSwitch;
    @BindView(R.id.iconLogin)
    ImageView iconLogin;
    @BindView(R.id.buttonNext)
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_validation);
        ButterKnife.bind(this);

        iconLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(aSwitch.isChecked()){
                   Intent intent = new Intent(ValidationActivity.this, SubscriptionActivity.class);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(ValidationActivity.this, "Please confirm the rules", Toast.LENGTH_SHORT).show();
               }

           }
       });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
