package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    private TextView ticks,ticks2,ticks3;
    private Button ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ticks = (TextView)findViewById(R.id.ticks);
        ticks2=(TextView)findViewById(R.id.ticks2);
        ticks3=(TextView)findViewById(R.id.ticks3);
        ret = (Button)findViewById(R.id.ret);

        ret.setOnClickListener(retListener);
        Bundle bundle=getIntent().getExtras();
        String s = bundle.getString("ticks");
        String s2 = bundle.getString("ticks2");
        String s3 = bundle.getString("ticks3");
        ticks.setText(s);
        ticks2.setText(s2);
        ticks3.setText(s3);


    }
    private Button.OnClickListener retListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent=new Intent();
            intent.setClass(Main6Activity.this,Main5Activity.class);
            startActivity(intent);
        }
    };
}
