package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameResultActivity extends AppCompatActivity {

    Button btn1;
    TextView tv3,tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        btn1=(Button)findViewById(R.id.btn1);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);

        btn1.setOnClickListener(btnlistener);
        Bundle bundle=getIntent().getExtras();
        int win=bundle.getInt("win");
        int lose=bundle.getInt("lose");
        int tie=bundle.getInt("tie");
        tv3.setText("贏:"+win+"次");
        tv4.setText("輸:"+lose+"次");
        tv5.setText("平手:"+tie+"次");

    }
    private Button.OnClickListener btnlistener=new
            Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(GameResultActivity.this,GameActivity.class);
            startActivity(intent);
        }
            };
}
