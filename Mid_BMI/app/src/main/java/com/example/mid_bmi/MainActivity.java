package com.example.mid_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText weight,high;
    private TextView result;
    private ImageView pic;
    private Button enter,clear;
    private RadioButton m_kg,cm_ib;
    private RadioGroup radioG;

    int [] img = {R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04};
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.value_w);
        high = (EditText) findViewById(R.id.value_h);
        result = (TextView)findViewById(R.id.result);
        pic = (ImageView)findViewById(R.id.pic);
        enter = (Button)findViewById(R.id.enter);
        clear =(Button)findViewById(R.id.clear);
        m_kg = (RadioButton)findViewById(R.id.m_kg);
        cm_ib = (RadioButton)findViewById(R.id.cm_ib);
        radioG = (RadioGroup)findViewById(R.id.radioG);



        enter.setOnClickListener(enterListener);
        clear.setOnClickListener(clearListener);
        radioG.setOnCheckedChangeListener(radListener);

    }

    private RadioGroup.OnCheckedChangeListener radListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            int p = group.indexOfChild((RadioButton)findViewById(checkedId));
            int count = group.getChildCount();
            if(checkedId == R.id.m_kg)
            {
                type=1;
            }
            else if (checkedId == R.id.cm_ib)
            {
                type=2;
            }
        }
    };
    private Button.OnClickListener clearListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v) {
            String str_w = weight.getText().toString();
            String str_h = high.getText().toString();
            if(str_h.length()>0 || str_w.length()>0)
            {
                str_h="";
                str_w="";
                high.setText(str_h);
                weight.setText(str_w);
            }

        }
    };
    private Button.OnClickListener enterListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            double m = Double.parseDouble(high.getText().toString());
            double kg = Double.parseDouble(weight.getText().toString());
            double cm = Double.parseDouble(high.getText().toString());
            double ib = Double.parseDouble(weight.getText().toString());

            if(type==1)
            {
                float bmi_1 = (float) (kg / (m * m));
                result.setText("" + (bmi_1));
                if(bmi_1<18.5)
                {
                    pic.setImageResource(img[0]);
                }
                else if(18.5<=bmi_1 && bmi_1<25)
                {
                    pic.setImageResource(img[1]);
                }
                else if(25<=bmi_1 && bmi_1 <30)
                {
                    pic.setImageResource(img[2]);
                }
                else if(30<=bmi_1)
                {
                    pic.setImageResource(img[3]);
                }

            }
            else if (type==2)
            {
                m = cm/100;
                kg = ib*0.454;
                float bmi_2 = (float)(kg / (m * m));
                result.setText(""+bmi_2);
            }
        }
    };
}
