package com.example.intent_3;

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

    private Button web, call, callto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (Button) findViewById(R.id.web);
        call = (Button) findViewById(R.id.call);
        callto = (Button) findViewById(R.id.callto);

        web.setOnClickListener(webListener);
        call.setOnClickListener(callListener);
        callto.setOnClickListener(calltoListener);

        requestPermission();
    }

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

    private Button.OnClickListener webListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.youtube.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
    };
    private Button.OnClickListener callListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {


            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                Uri uri = Uri.parse("tel:0988650840");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        }
    };
    private Button.OnClickListener calltoListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("tel:0988650840");
            Intent intent_3 = new Intent(Intent.ACTION_CALL, uri);
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                finish();
            }
            else
            {
                startActivity(intent_3);
            }

        }
    };
}
