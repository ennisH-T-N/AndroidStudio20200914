package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    int win,lose,tie;
    Button btn1,btn2,btn3,btn4;
    ImageView imv6;
    TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tv3=(TextView)findViewById(R.id.tv3);
        imv6=(ImageView)findViewById(R.id.imv6);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);

        btn4.setOnClickListener(btnlistener);
        btn1.setOnClickListener(paperlistener);
        btn2.setOnClickListener(scissorlistener);
        btn3.setOnClickListener(stonelistener);

    }

    private Button.OnClickListener paperlistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    int AIplayer=(int)(Math.random()*3+1);
                    if(AIplayer==1){
                        imv6.setImageResource(R.drawable.scissor);
                        tv3.setText("此次結果為:輸");
                        lose++;
                    }
                    else if(AIplayer==2){
                        imv6.setImageResource(R.drawable.stone);
                        tv3.setText("此次結果為:贏");
                        win++;
                    }
                    else{
                        imv6.setImageResource(R.drawable.paper);
                        tv3.setText("此次結果為:平手");
                        tie++;
                    }
                }
            };
    private Button.OnClickListener scissorlistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    int AIplayer=(int)(Math.random()*3+1);
                    if(AIplayer==1){
                        imv6.setImageResource(R.drawable.scissor);
                        tv3.setText("此次結果為:平手");
                        tie++;
                    }
                    else if(AIplayer==2){
                        imv6.setImageResource(R.drawable.stone);
                        tv3.setText("此次結果為:輸");
                        lose++;
                    }
                    else{
                        imv6.setImageResource(R.drawable.paper);
                        tv3.setText("此次結果為:贏");
                        win++;
                    }
                }
            };
    private Button.OnClickListener stonelistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    int AIplayer=(int)(Math.random()*3+1);
                    if(AIplayer==1){
                        imv6.setImageResource(R.drawable.scissor);
                        tv3.setText("此次結果為:贏");
                        win++;
                    }
                    else if(AIplayer==2){
                        imv6.setImageResource(R.drawable.stone);
                        tv3.setText("此次結果為:平手");
                        tie++;
                    }
                    else{
                        imv6.setImageResource(R.drawable.paper);
                        tv3.setText("此次結果為:輸");
                        lose++;
                    }
                }
            };
    private Button.OnClickListener btnlistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    Intent intent=new Intent();
                    intent.setClass(GameActivity.this,GameResultActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("win",win);
                    bundle.putInt("lose",lose);
                    bundle.putInt("tie",tie);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            };
}
