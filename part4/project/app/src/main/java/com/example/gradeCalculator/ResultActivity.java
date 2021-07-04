package com.example.gradeCalculator;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;
        import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static String ResultLog= "Result";

    TextView result_tv, android_mark_tv, java_mark_tv, xml_mark_tv, kotlin_mark_tv;
    int android_mark, java_mark, kotlin_mark, xml_mark, result_Avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ResultLog, "Navid Vadsariya 136884186");
        setContentView(R.layout.result_activity);


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

            result_Avg = (android_mark + java_mark + xml_mark + kotlin_mark) / 4;

            String avg = "Result : " + String.valueOf(result_Avg);

            android_mark_tv = findViewById(R.id.android_mark_tv);
            java_mark_tv = findViewById(R.id.java_mark_tv);
            xml_mark_tv = findViewById(R.id.xml_mark_tv);
            kotlin_mark_tv = findViewById(R.id.kotlin_mark_tv);
            result_tv = findViewById(R.id.result_tv);


            android_mark_tv.setText(android_value);
            java_mark_tv.setText(java_value);
            xml_mark_tv.setText(xml_value);
            kotlin_mark_tv.setText(kotlin_value);

            result_tv.setText( avg);
            Log.i(ResultLog, "bundle done");


        }
        else{
            Log.i(ResultLog, "bundle is null.");
        }

    }
}