package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    ImageView imgbtn1,imgbtn2,imgbtn3,imgbtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=(Button)findViewById(R.id.btn4);
        imgbtn1=(ImageButton)findViewById(R.id.imgbtn1);
        imgbtn2=(ImageButton)findViewById(R.id.imgbtn2);
        imgbtn3=(ImageButton)findViewById(R.id.imgbtn3);
        imgbtn4=(ImageButton)findViewById(R.id.imgbtn4);
        btn1.setOnClickListener(btnlistener);
        imgbtn1.setOnClickListener(btn1listener);
        imgbtn2.setOnClickListener(btn2listener);
        imgbtn3.setOnClickListener(btn3listener);
        imgbtn4.setOnClickListener(btn4listener);

        requestPermissions();
    }
    private void requestPermissions(){
        if(Build.VERSION.SDK_INT>=23){
            int hasPermission= ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if(hasPermission!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
            }
        }
    }

        public void onRequestPermissionResult(int requestCode, String[] permissions,int[] grantResults){
            if(requestCode==1){
                if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"未取得授權!",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            else{
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
            }
        }
     private ImageButton.OnClickListener btn1listener=new
                ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this,MenuActivity.class);
                        startActivity(intent);
                    }
                };

        private ImageButton.OnClickListener btn2listener=new
                ImageButton.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.imgbtn2:{
                        Uri uri=Uri.parse("tel:0958762401");
                        Intent intent=new Intent(Intent.ACTION_CALL,uri);
                        if(ActivityCompat.checkSelfPermission(
                                MainActivity.this,Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                            startActivity(intent);
                        }
                        break;
                    }
                }
            }
                };
    private ImageButton.OnClickListener btn3listener=new
            ImageButton.OnClickListener(){
                public void onClick(View v){
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,GameActivity.class);
                    startActivity(intent);
                }
            };

        private ImageButton.OnClickListener btn4listener=new
                ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this,MapsActivity.class);
                        startActivity(intent);
                    }
                };

        private Button.OnClickListener btnlistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            };
}
