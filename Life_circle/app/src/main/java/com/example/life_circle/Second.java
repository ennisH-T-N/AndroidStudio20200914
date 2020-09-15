package com.example.life_circle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1 = (Button)findViewById(R.id.b1);

        b1.setOnClickListener(myListener);
        Toast.makeText(getApplicationContext(),"onCreate(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onStart()
    {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop(2)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy(2)",Toast.LENGTH_LONG).show();
    }

    private Button.OnClickListener myListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
           finish();
        }
    };
}
