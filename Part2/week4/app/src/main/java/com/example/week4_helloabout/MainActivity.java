package com.example.week4_helloabout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static String TAG = "Assignment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "Navid Vadsariya 136884186");

        setContentView(R.layout.activity_main);
        View aboutbtn = findViewById(R.id.about_btn);
        aboutbtn.setOnClickListener(this);

        View exitbtn = findViewById(R.id.about_btn);
        exitbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_btn:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            case R.id.exit_btn:
                finish();
                break;
        }
    }

}

