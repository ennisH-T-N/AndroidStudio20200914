package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main5Activity extends AppCompatActivity {

    private Button go,result;
    private ImageView img;
    private TextView show;
    String[] luckey = new String[]{"None","None","None","None","None","None","None","None","None","None","None","None","None","None","None","None"
            ,"50% discount","80% discount","80% discount","90% discount","90% discount","95% discount","95% discount","95% discount"};
    int [] game = new int[]{R.drawable.game,R.drawable.game2,R.drawable.game3,R.drawable.game4};
    int count=1;
    int p=0;
    String s ,s2,s3;
    String ss[] = new String[]{};
    int chance = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        go = (Button)findViewById(R.id.go);
        img = (ImageView) findViewById(R.id.img);
        show =(TextView)findViewById(R.id.show);
        result = (Button)findViewById(R.id.result);

        go.setOnClickListener(goListener);
        result.setOnClickListener(resultListener);

    }
    private Button.OnClickListener goListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {

            int i = (int)(Math.random()*25);

            count+=1;
            p+=1;
            if(chance>0) {
                if (count % 4 == 0) {
                    img.setImageResource(game[p % 4]);
                    if((count % 12 == 4)) {
                        show.setText(luckey[i]);
                        s = luckey[i];
                        chance -= 1;
                    }
                    else if((count % 12 == 8))
                    {
                        show.setText(luckey[i]);
                        s2 = luckey[i];
                        chance -= 1;
                    }
                    else if((count % 12 == 0))
                    {
                        show.setText(luckey[i]);
                        s3 = luckey[i];
                        chance -= 1;
                    }
                } else if (count % 4 == 1) {
                    img.setImageResource(game[p % 4]);


                } else if (count % 4 == 2) {
                    img.setImageResource(game[p % 4]);

                } else if (count % 4 == 3) {
                    img.setImageResource(game[p % 4]);

                }
            }
            else
            {
                Toast toast = Toast.makeText(Main5Activity.this,"No Chance!!",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };
    private Button.OnClickListener resultListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(Main5Activity.this,Main6Activity.class);
            Bundle bundle = new Bundle();

            bundle.putString("ticks",s);
            bundle.putString("ticks2",s2);
            bundle.putString("ticks3",s3);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
}
