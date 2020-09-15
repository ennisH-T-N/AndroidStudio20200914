package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        show = (TextView)findViewById(R.id.show);

        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        Double high = bundle.getDouble("HIGH:");
        Double weight = bundle.getDouble("WEIGHT:");
        Double BMI = bundle.getDouble("BMI:");
        String s = "HIGH:" + high + "\n" +"WIGHT:" + weight + "\n" + "BMI:" + BMI;

        show.setText(s);

    }
}
