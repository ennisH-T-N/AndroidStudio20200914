package com.example.mid_order;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Spinner Spinner_food_type;
    private TextView h,f,t,c,h_c;
    private Button h_i,h_d;
    int[] e={0,0,0,0};
    int[]up={R.id.h_i};
    int[]down={R.id.h_d};
    int[]number={R.id.h_c};
    Button btn_up[] = new Button[5];
    Button btn_down[] = new Button[5];
    TextView num[] = new TextView[5];
    String s="";
    String[] food_type=  new String[] {"麵類","飯類","漢堡"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (TextView)findViewById(R.id.h);
        h_c = (TextView)findViewById(R.id.h_c);
        h_i = (Button)findViewById(R.id.h_i);
        h_d = (Button)findViewById(R.id.h_d);
        f = (TextView)findViewById(R.id.f);
        t = (TextView)findViewById(R.id.t);
        c = (TextView)findViewById(R.id.c);

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
    private void UP(View v) {
        for (int i = 0; i < btn_up.length; i++) {
            if (v == btn_up[i]) {
                e[i]++;//遞增，用陣列來存取每個餐點的數量
                s = Integer.toString(e[i]);
                num[i].setText(s);
            }
        }
    };
}
