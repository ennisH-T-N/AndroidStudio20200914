package com.example.y20200612;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText edtname;
    private Button btnClear,btnEnd;
    private TextView txtname;
    private SharedPreferences preference;
    private String msg,sname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = (EditText)findViewById(R.id.edtname);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        txtname = (TextView)findViewById(R.id.txtname);

        btnClear.setOnClickListener(Listener);
        btnEnd.setOnClickListener(Listener);

        preference = getSharedPreferences("preFile",MODE_PRIVATE);
        sname = preference.getString("name","");

        if(sname.equals(""))
        {
            txtname.setVisibility(TextView.VISIBLE);
            edtname.setVisibility(TextView.VISIBLE);
            btnClear.setVisibility(Button.INVISIBLE);
            msg = "歡迎使用本應用程式!\n你尚未建立基本資料，請輸入姓名!";
        }
        else
        {
            msg="親愛的"+sname+"您好!\n歡迎再次使用本應用程式";
        }
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("歡迎使用本軟體!")
                .setMessage(msg)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
    private Button.OnClickListener Listener =  new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnEnd:
                    finish();
                    break;
                case R.id.btnClear:
                    if(!sname.equals(""))
                    {
                        preference.edit()
                                .clear()
                                .commit();
                        Toast.makeText(getApplicationContext(),"所有資料都已清除!",Toast.LENGTH_LONG).show();
                    }
                    btnClear.setVisibility(Button.INVISIBLE);
                    break;
            }
        }
    };
    protected void onStop()
    {
        super.onStop();
        if(sname.equals(""))
        {
            preference.edit()
                    .putString("name",edtname.getText().toString())
                    .commit();
        }
    }
}
