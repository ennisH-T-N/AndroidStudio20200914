package com.example.finalwork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Button enter;
    private Spinner spinner,spinner2,spinner3;
    private TextView show,show2,show3;
    private EditText num,num2,num3;
    String[] coffee = new String[]{"1.latte ","2.Matcha","None"};
    String[] cake = new String[]{"3.Spring","4.Loving","5.Pearl","6.Milkroll","None"};
    String[] other = new String[]{"7.Coco","8.Foot","9.Toast","10.muffin","None"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        enter = (Button)findViewById(R.id.enter);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        show = (TextView)findViewById(R.id.show);
        show2 = (TextView)findViewById(R.id.show2);
        show3 = (TextView)findViewById(R.id.show3);
        num = (EditText)findViewById(R.id.num);
        num2 = (EditText)findViewById(R.id.num2);
        num3 = (EditText)findViewById(R.id.num3);

        ArrayAdapter<String> adtcoffee = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,coffee);
        ArrayAdapter<String> adtcake = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cake);
        ArrayAdapter<String> adtother = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,other);

        adtcoffee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adtcake.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adtother.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adtcoffee);
        spinner2.setAdapter(adtcake);
        spinner3.setAdapter(adtother);

        spinner.setOnItemSelectedListener(s1Listener);
        spinner2.setOnItemSelectedListener(s2Listener);
        spinner3.setOnItemSelectedListener(s3Listener);
        enter.setOnClickListener(enterListener);

    }
    private Spinner.OnItemSelectedListener s1Listener = new Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String sel = parent.getSelectedItem().toString();
            show.setText(sel);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };
    private  Spinner.OnItemSelectedListener s2Listener = new Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String sel2 = parent.getSelectedItem().toString();
            show2.setText(sel2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };
    private  Spinner.OnItemSelectedListener s3Listener = new Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String sel3 = parent.getSelectedItem().toString();
            show3.setText(sel3);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };
    private Button.OnClickListener enterListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.enter:
                    new AlertDialog.Builder(Main3Activity.this)
                            .setTitle("Ensure")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("Coffee_"+show.getText().toString() + ":"+ num.getText().toString()+"cup(s)"
                                    +"\n"+"Cake_"+show2.getText().toString()+ ":"+ num2.getText().toString()+"piece(s)"
                                    +"\n"+"Other_"+show3.getText().toString()+ ":"+ num3.getText().toString()+"thing(s)")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                    break;
            }
        }
    };

}
