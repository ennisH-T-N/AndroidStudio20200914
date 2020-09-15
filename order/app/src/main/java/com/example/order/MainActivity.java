package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner Spinner_food_type;
    String[] food_type=  new String[] {"麵類","飯類","素食","漢堡"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner_food_type = (Spinner)findViewById(R.id.spinner_food_type);

        ArrayAdapter<String> food_type_select = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,food_type);

        food_type_select.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner_food_type.setAdapter(food_type_select);

        Spinner_food_type.setOnItemSelectedListener(Spinner_food_type_Listener);
    }

    private Spinner.OnItemSelectedListener Spinner_food_type_Listener = new Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String sel = parent.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
