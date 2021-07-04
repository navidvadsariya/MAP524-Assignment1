package com.example.gradeCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MinimunActivity extends AppCompatActivity {

    private static String Min = "Min";

    TextView min_result_tv, android_mark_tv, java_mark_tv, xml_mark_tv, kotlin_mark_tv;
    int android_mark, java_mark, kotlin_mark, xml_mark, result_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimun);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            String android_value = bundle.getString("android_value");
            String java_value = bundle.getString("java_value");
            String xml_value = bundle.getString("xml_value");
            String kotlin_value = bundle.getString("kotlin_value");

            android_mark = Integer.parseInt(android_value);
            java_mark = Integer.parseInt(java_value);
            xml_mark = Integer.parseInt(xml_value);
            kotlin_mark = Integer.parseInt(kotlin_value);

            result_min = android_mark;

            if(result_min > java_mark){
                result_min = java_mark;
            }

             if(result_min > xml_mark){
                result_min = xml_mark;
            }

             if(result_min > kotlin_mark){
                result_min = kotlin_mark;
            }

            String min = String.valueOf(result_min);

            android_mark_tv = findViewById(R.id.android_mark_tv);
            java_mark_tv = findViewById(R.id.java_mark_tv);
            xml_mark_tv = findViewById(R.id.xml_mark_tv);
            kotlin_mark_tv = findViewById(R.id.kotlin_mark_tv);
            min_result_tv = findViewById(R.id.min_result);


            android_mark_tv.setText(android_value);
            java_mark_tv.setText(java_value);
            xml_mark_tv.setText(xml_value);
            kotlin_mark_tv.setText(kotlin_value);

            min_result_tv.setText(min);
        }
        else{
            Log.i(Min, "bundle is null.");
        }

    }
}