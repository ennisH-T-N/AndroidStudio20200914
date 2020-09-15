package com.example.a202020914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView name,vic,our,computer;
    private EditText inputname;
    private Button enter;
    private RadioButton scissor,stone,paper;
    private RadioGroup group;
    int num=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        vic  = findViewById(R.id.vic);
        our = findViewById(R.id.our);
        computer = findViewById(R.id.computer);
        inputname = findViewById(R.id.inputname);
        enter = findViewById(R.id.enter);
        scissor = findViewById(R.id.scissor);
        stone = findViewById(R.id.stone);
        paper = findViewById(R.id.paper);
        group = findViewById(R.id.group);


        enter.setOnClickListener(enterListener);
        group.setOnCheckedChangeListener(groupListener);

    }

    private RadioGroup.OnCheckedChangeListener groupListener = new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {


            if(checkedId == R.id.scissor)
            {
                num=1;
            }
            else if(checkedId == R.id.stone)
            {
                num=2;
            }
            else if(checkedId==R.id.paper)
            {
                num=3;
            }
        }
    };
    private Button.OnClickListener enterListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            String str=inputname.getText().toString();

            if(str.isEmpty())
            {

                Toast toast=Toast.makeText(MainActivity.this,"請輸入名字，以便開始遊戲",Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                name.setText("");
                name.setText(str);
                int r = (int)(Math.random()*3+1);
                if(r==1)
                {
                    computer.setText("剪刀");
                    if(num==1)
                    {
                        our.setText("剪刀");
                        vic.setText("平手");
                    }
                    else if(num==2)
                    {
                        our.setText("石頭");
                        vic.setText("玩家");
                    }
                    else if(num==3)
                    {
                        our.setText("布");
                        vic.setText("電腦");
                    }

                }
                else if(r==2)
                {
                    computer.setText("石頭");
                    if(num==1)
                    {
                        our.setText("剪刀");
                        vic.setText("電腦");
                    }
                    else if(num==2)
                    {
                        our.setText("石頭");
                        vic.setText("平手");
                    }
                    else if(num==3)
                    {
                        our.setText("布");
                        vic.setText("玩家");
                    }
                }
                else if(r==3)
                {
                    computer.setText("布");
                    if(num==1)
                    {
                        our.setText("剪刀");
                        vic.setText("玩家");
                    }
                    else if(num==2)
                    {
                        our.setText("石頭");
                        vic.setText("電腦");
                    }
                    else if(num==3)
                    {
                        our.setText("布");
                        vic.setText("平手");
                    }
                }
            }





            }




    };
}
