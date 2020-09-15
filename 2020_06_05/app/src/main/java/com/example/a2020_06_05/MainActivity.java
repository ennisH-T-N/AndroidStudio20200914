package com.example.a2020_06_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);

        bt1.setOnClickListener(bt1Listener);
        bt2.setOnClickListener(bt2Listener);
    }
    private Button.OnClickListener bt1Listener = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener bt2Listener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MapsActivity.class);
            startActivity(intent);
        }
    };

}
