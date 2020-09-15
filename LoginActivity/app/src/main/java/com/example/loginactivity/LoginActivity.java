package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btn1;
    TextView tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn4);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        String webLinkText1= "<a href='https://support.google.com/accounts/answer/27441?hl=zh-Hant'>註冊會員</a>" ;
        tv3.setText(Html.fromHtml(webLinkText1));
        tv3.setMovementMethod(LinkMovementMethod.getInstance());
        String webLinkText2= "<a href='https://support.google.com/mail/answer/41078?co=GENIE.Platform%3DDesktop&hl=zh-Hant'>找回密碼?</a>" ;
        tv4.setText(Html.fromHtml(webLinkText2));
        tv4.setMovementMethod(LinkMovementMethod.getInstance());

        btn1.setOnClickListener(btnlistener);
    }
    private Button.OnClickListener btnlistener=new
            Button.OnClickListener(){
                public void onClick(View v){
                    Intent intent=new Intent();
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            };
}

