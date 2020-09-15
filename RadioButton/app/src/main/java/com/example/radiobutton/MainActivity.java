package com.example.radiobutton;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView txtresult;
    private CheckBox cb1,cb2,cb3;

    private TextView txtresult2;
    private RadioButton r1,r2,r3;
    private RadioGroup g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtresult = (TextView)findViewById(R.id.result);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);

        cb1.setOnCheckedChangeListener(myListener);
        cb2.setOnCheckedChangeListener(myListener);
        cb3.setOnCheckedChangeListener(myListener);


        txtresult2=(TextView)findViewById(R.id.result2);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        g = (RadioGroup)findViewById(R.id.gr);

        g.setOnCheckedChangeListener(rListener);

    }

    private CheckBox.OnCheckedChangeListener myListener = new CheckBox.OnCheckedChangeListener()
    {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            int n =0;
            String sel="";
            String s1=" ",s2="",s3="";
            if(cb1.isChecked())
            {
                n++;
                s1 = cb1.getText().toString()+",";
            }
            else
            {
                s1="";
            }
            if(cb2.isChecked())
            {
                n++;
                s2 = cb2.getText().toString()+",";
            }
            else
            {
                s2="";
            }
            if(cb3.isChecked())
            {
                n++;
                s3 = cb3.getText().toString()+",";
            }
            else
            {
                s3="";
            }
            sel = s1 + s2 + s3;
            txtresult.setText("喜歡的有球類運動有："  + sel + "共有" + n +"種" );

        }
    };

    private RadioGroup.OnCheckedChangeListener rListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            int p = group.indexOfChild((RadioButton)findViewById(checkedId));
            int count = group.getChildCount();

            if(checkedId==R.id.r1)
            {
                txtresult2.setText(count + "項球類中，最喜歡第"+(p+1)+"項"+r1.getText());
            }
            else if(checkedId==R.id.r2)
            {
                txtresult2.setText(count + "項球類中，最喜歡第"+(p+1)+"項"+r2.getText());
            }
            else if(checkedId==R.id.r3)
            {
                txtresult2.setText(count + "項球類中，最喜歡第"+(p+1)+"項"+r3.getText());
            }
        }
    };
}
