package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Button in;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        in = (Button)findViewById(R.id.in);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        in.setOnClickListener(inListener);
    }
    private Button.OnClickListener inListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(Main2Activity.this,MainActivity.class);
            startActivity(intent);

        }
    };
}
