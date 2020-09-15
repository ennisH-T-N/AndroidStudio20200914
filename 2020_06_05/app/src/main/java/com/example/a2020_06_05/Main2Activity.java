package com.example.a2020_06_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Spinner spinner;
    private TextView txt;
    String[] keys = new String[] {"H","T","N","L"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = (Spinner)findViewById(R.id.spinner);
        txt = (TextView)findViewById(R.id.txt);

        ArrayAdapter<String> adapterkeys = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,keys);

        adapterkeys.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterkeys);

        spinner.setOnItemSelectedListener(spinnerListener);


    }
    private Spinner.OnItemSelectedListener spinnerListener =  new Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String sel = parent.getSelectedItem().toString();
            txt.setText(sel);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };
}
