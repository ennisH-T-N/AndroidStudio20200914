package com.example.life_circle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 =(Button)findViewById(R.id.b1);
        b2 =(Button)findViewById(R.id.b2);
        b3 =(Button)findViewById(R.id.b3);

        b1.setOnClickListener(myListener);
        b2.setOnClickListener(myListener);
        b3.setOnClickListener(myListener);
        Toast.makeText(getApplicationContext(),"onCreate(1)",Toast.LENGTH_LONG).show();
    }
     @Override protected void onStart()
     {
         super.onStart();
         Toast.makeText(getApplicationContext(),"onStart(1)",Toast.LENGTH_LONG).show();
     }
    @Override protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume(1)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart(1)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause(1)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop(1)",Toast.LENGTH_LONG).show();
    }
    @Override protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy(1)",Toast.LENGTH_LONG).show();
    }



    private Button.OnClickListener myListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            if(v.getId()==R.id.b1)
            {
                Uri uri = Uri.parse("tel:0988650888");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
            else if(v.getId()==R.id.b2)
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Second.class);
                startActivity(intent);
            }
            else if (v.getId()==R.id.b3)
            {
                finish();
            }
        }
    };
}
