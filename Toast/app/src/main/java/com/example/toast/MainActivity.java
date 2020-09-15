package com.example.toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1.
    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

    }

    //3.
    public void onClick(View v)
    {
        Toast toast = Toast.makeText(MainActivity.this,"toast test",Toast.LENGTH_LONG);
        //toast.setGravity(Gravity.TOP,-100,0); //設定顯示toast顯示的位置
        toast.show();
    }

    public void onAlert(View v) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("確認視窗")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("確定要結束應用程式嗎?")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();

    }
};
