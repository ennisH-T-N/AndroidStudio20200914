package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3;
    private TextView txtshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        txtshow = (TextView)findViewById(R.id.txtshow);


        cb1.setOnCheckedChangeListener(myListener);
        cb2.setOnCheckedChangeListener(myListener);
        cb3.setOnCheckedChangeListener(myListener);

    }

    private CheckBox.OnClickListener myListener = new CheckBox.OnCheckedChangeListener()
    {
    public void OnCheckedChanged(CompoundButton buttomView,boolean isChecked) {
        int n = 0;
        String str = "";
        String s1, s2, s3 = "";
        if (cb1.isChecked()) {
            n++;
            s1 = cb1.getText().toString() + " ";
        } else {
            s1 = "";
        }
        if (cb2.isChecked()) {
            n++;
            s2 = cb2.getText().toString() + " ";
        } else {
            s2 = "";
        }
        if (cb3.isChecked()) {
            n++;
            s3 = cb3.getText().toString() + " ";
        } else {
            s3 = "";
        }
        str = s1 + s2 + s3;
        txtshow.setText("最喜歡的球類運動共有:" + str + "," + n + "種");

    }
    };
}
