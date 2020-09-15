package com.example.intent_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView show;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        show = (TextView)findViewById(R.id.show);
        btn = (Button)findViewById(R.id.btn);


        btn.setOnClickListener(webListenter);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String mail = bundle.getString("Email");
        String pass = bundle.getString("password");
        String s = "Email:" + mail + "\n" + "Password:" + pass;
        show.setText(s);
    }
    private Button.OnClickListener webListenter = new Button.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            Uri uri = Uri.parse("http://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }
    };
}
