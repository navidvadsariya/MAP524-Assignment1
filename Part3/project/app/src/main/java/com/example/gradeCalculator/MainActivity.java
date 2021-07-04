package com.example.gradeCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String HELP_DIALOG_TAG = "HELP_DIALOG_TAG";

    private static String LOGTAG= "GradeCalculator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(LOGTAG, "Navid Vadsariya 136884186");

        setContentView(R.layout.activity_main);



        View submitbtn = findViewById(R.id.submit_grade);
        submitbtn.setOnClickListener(this);

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

        Bundle bundle = new Bundle();

        bundle.putString("android_value",android_str);
        bundle.putString("xml_value",xml_str);
        bundle.putString("java_value",java_str);
        bundle.putString("kotlin_value",kotlin_str);

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtras(bundle);
        startActivity(i);
        
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
        switch(item.getItemId()){
            case R.id.menu_contact_us:
                this.contactUs();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void exitApp() {
        this.finishAffinity();
    }

    private void contactUs() {
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }


}