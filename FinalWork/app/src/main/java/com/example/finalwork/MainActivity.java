package com.example.finalwork;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button menu,order,game,call,map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu =(Button)findViewById(R.id.menu);
        order =(Button)findViewById(R.id.order);
        game =(Button)findViewById(R.id.game);
        call =(Button)findViewById(R.id.call);
        map =(Button)findViewById(R.id.map);

        menu.setOnClickListener(menuListener);
        order.setOnClickListener(orderListener);
        game.setOnClickListener(gameListener);
        call.setOnClickListener(callListener);
        map.setOnClickListener(mapListener);

        requestPermission();
    }

    private Button.OnClickListener menuListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main4Activity.class);
            startActivity(intent);
        }
    };
    private  Button.OnClickListener orderListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
    };
    private  Button.OnClickListener gameListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main5Activity.class);
            startActivity(intent);
        }
    };
    private void requestPermission() {
        if (Build.VERSION.SDK_INT > 23) {
            int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "未取得授權", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private Button.OnClickListener callListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {

            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
            else
            {
                Uri uri = Uri.parse("tel:0988650840");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        }
    };
    private  Button.OnClickListener mapListener = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MapsActivity.class);
            startActivity(intent);
        }
    };
}
