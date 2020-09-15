package com.example.phonenumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView txtShow;
    private Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
    private Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow=(TextView)findViewById(R.id.txtShow);
        btnZero=(Button)findViewById(R.id.btnZero);
        btnOne=(Button)findViewById(R.id.btnOne);
        btnTwo=(Button)findViewById(R.id.btnTwo);
        btnThree=(Button)findViewById(R.id.btnThree);
        btnFour=(Button)findViewById(R.id.btnFour);
        btnFive=(Button)findViewById(R.id.btnFive);
        btnSix=(Button)findViewById(R.id.btnSix);
        btnSeven=(Button)findViewById(R.id.btnSeven);
        btnEight=(Button)findViewById(R.id.btnEight);
        btnNine=(Button)findViewById(R.id.btnNine);
        btnToast=(Button)findViewById(R.id.btnToast);

        btnZero.setOnClickListener(myListener);
        btnOne.setOnClickListener(myListener);
        btnTwo.setOnClickListener(myListener);
        btnThree.setOnClickListener(myListener);
        btnFour.setOnClickListener(myListener);
        btnFive.setOnClickListener(myListener);
        btnSix.setOnClickListener(myListener);
        btnSeven.setOnClickListener(myListener);
        btnEight.setOnClickListener(myListener);
        btnNine.setOnClickListener(myListener);
        btnToast.setOnClickListener(myListener);
    }

    private Button.OnClickListener myListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v) {
            String s = txtShow.getText().toString();
            switch(v.getId())
            {
                case R.id.btnZero:
                {
                    txtShow.setText(s+"0");
                    break;
                }
                case R.id.btnOne:
                {
                    txtShow.setText(s+"1");
                    break;
                }
                case R.id.btnTwo:
                {
                    txtShow.setText(s+"2");
                    break;
                }
                case R.id.btnThree:
                {
                    txtShow.setText(s+"3");
                    break;
                }
                case R.id.btnFour:
                {
                    txtShow.setText(s+"4");
                    break;
                }
                case R.id.btnFive:
                {
                    txtShow.setText(s+"5");
                    break;
                }
                case R.id.btnSix:
                {
                    txtShow.setText(s+"6");
                    break;
                }
                case R.id.btnSeven:
                {
                    txtShow.setText(s+"7");
                    break;
                }
                case R.id.btnEight:
                {
                    txtShow.setText(s+"8");
                    break;
                }
                case R.id.btnNine:
                {
                    txtShow.setText(s+"9");
                    break;
                }
                case R.id.btnClear:
                {
                    String str = txtShow.getText().toString();
                    if(str.length()>0)
                    {
                        str = str.substring(0,str.length()-1);
                        txtShow.setText(str);
                    }
                }
                case R.id.btnToast:
                {
                    Toast toast= Toast.makeText(MainActivity.this,"Toast快顯測試", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }


            }
        }
    };
}
