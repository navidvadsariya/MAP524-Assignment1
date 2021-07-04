package com.example.gradeCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static String LOGTAG= "GradeCalculator";
    AutoCompleteTextView autocomplete;
    String[] arr = {   "Seneca Valley College", "Hummingbird Academy"," Harrington High"," Georgian Bay College",
            "Saracuse Academy","St-Vincent College"," Seneca College"," Seneca York"," Seneca North"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Log.i(LOGTAG, "Navid Vadsariya 136884186");

        setContentView(R.layout.activity_main);

        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.Colleges);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        autocomplete.setThreshold(1);
        autocomplete.setAdapter(adapter);


        View submitbtn = findViewById(R.id.submit_grade);
        submitbtn.setOnClickListener(this);

        View minbtn = findViewById(R.id.min_btn);
        minbtn.setOnClickListener(this);

        View maxbtn = findViewById(R.id.max_btn);
        maxbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final EditText android_mark= findViewById(R.id.android_mark);
        final EditText xml_mark= findViewById(R.id.xml_mark);
        final EditText java_mark= findViewById(R.id.java_mark);
        final EditText kotlin_mark= findViewById(R.id.kotlin_mark);


        String android_str = android_mark.getText().toString().trim();
        String xml_str = xml_mark.getText().toString().trim();
        String java_str = java_mark.getText().toString().trim();
        String kotlin_str = kotlin_mark.getText().toString().trim();


        boolean value =  this.validation(java_str,xml_str,kotlin_str,android_str);

        if(value){


        Bundle bundle = new Bundle();

        bundle.putString("android_value",android_str);
        bundle.putString("xml_value",xml_str);
        bundle.putString("java_value",java_str);
        bundle.putString("kotlin_value",kotlin_str);



            switch (v.getId()) {
                case R.id.submit_grade:
                    Intent i = new Intent(this, ResultActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                    break;
                case R.id.min_btn:
                    Intent i_min = new Intent(this, MinimunActivity.class);
                    i_min.putExtras(bundle);
                    startActivity(i_min);
                    break;
                case R.id.max_btn:
                    Intent i_max = new Intent(this, MaximumActivity.class);
                    i_max.putExtras(bundle);
                    startActivity(i_max);
                    break;
            }
        }
    }

    private boolean validation(String javaStr, String xmlStr, String kotlinStr, String androidStr){
        if(javaStr != null && !javaStr.isEmpty()){
            if(xmlStr != null && !xmlStr.isEmpty()){
                if(kotlinStr != null && !kotlinStr.isEmpty()){
                    if(androidStr != null && !androidStr.isEmpty()){
                        return true;
                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "Enter mark for ANDROID",Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter mark for KOTLIN",   Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Enter mark for XML",   Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Enter mark for JAVA",   Toast.LENGTH_SHORT).show();
        }
      return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final EditText android_mark= findViewById(R.id.android_mark);
        final EditText xml_mark= findViewById(R.id.xml_mark);
        final EditText java_mark= findViewById(R.id.java_mark);
        final EditText kotlin_mark= findViewById(R.id.kotlin_mark);


        String android_str = android_mark.getText().toString().trim();
        String xml_str = xml_mark.getText().toString().trim();
        String java_str = java_mark.getText().toString().trim();
        String kotlin_str = kotlin_mark.getText().toString().trim();

        boolean value =  this.validation(java_str,xml_str,kotlin_str,android_str);

        if(value) {
            switch (item.getItemId()) {
                case R.id.menu_min:
                    this.min();
                    break;
                case R.id.menu_avg:
                    this.avg();
                    break;
                case R.id.menu_max:
                    this.max();
                    break;
                case R.id.menu_about:
                    this.about();
                    break;
            }
        }
        switch (item.getItemId()) {

            case R.id.menu_about:
                this.about();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private Bundle sendDataToBundle() {
        final EditText android_mark= findViewById(R.id.android_mark);
        final EditText xml_mark= findViewById(R.id.xml_mark);
        final EditText java_mark= findViewById(R.id.java_mark);
        final EditText kotlin_mark= findViewById(R.id.kotlin_mark);

        String android_str = android_mark.getText().toString().trim();
        String xml_str = xml_mark.getText().toString().trim();
        String java_str = java_mark.getText().toString().trim();
        String kotlin_str = kotlin_mark.getText().toString().trim();

        Bundle bundle = new Bundle();

        bundle.putString("android_value",android_str);
        bundle.putString("xml_value",xml_str);
        bundle.putString("java_value",java_str);
        bundle.putString("kotlin_value",kotlin_str);

        return bundle;
    }

    private void about() {
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    private void min() {
        Intent i = new Intent(this, MinimunActivity.class);
        i.putExtras(this.sendDataToBundle());
        startActivity(i);
    }
    private void max() {
        Intent i = new Intent(this, MaximumActivity.class);
        i.putExtras(this.sendDataToBundle());
        startActivity(i);
    }
    private void avg() {
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtras(this.sendDataToBundle());
        startActivity(i);
    }

}