package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText high,weight;
    private Button enter;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        high = (EditText) findViewById(R.id.high);
        weight = (EditText) findViewById(R.id.weight);
        enter = (Button)findViewById(R.id.enter);
        result = (TextView)findViewById(R.id.result);

        enter.setOnClickListener(enterListener);
    }
    private Button.OnClickListener enterListener = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            double m = Double.parseDouble(high.getText().toString());
            double kg = Double.parseDouble(weight.getText().toString());
            double BMI = kg/(m*m);
            result.setText(""+BMI);

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main2Activity.class);


            Bundle bundle = new Bundle();
            bundle.putDouble("HIGH:",m);
            bundle.putDouble("WEIGHT:",kg);
            bundle.putDouble("BMI:",BMI);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };

}
