package com.example.intent_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button enter;
    private EditText Email,password;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        enter = (Button)findViewById(R.id.enter);
        Email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.password);

        enter.setOnClickListener(enterlistener);
    }
    private Button.OnClickListener enterlistener = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main2Activity.class);


            String mail = Email.getText().toString();
            String pass = password.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("Email",mail);
            bundle.putString("password",pass);
            intent.putExtras(bundle);

            startActivity(intent);

        }
    };
}
