package com.example.myimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int imgId[] = {R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06};
    private Button pre,next;
    private ImageView imageView;
    int p =0;
    int count = imgId.length;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pre = (Button)findViewById(R.id.pre);
        next = (Button)findViewById(R.id.next);
        imageView = (ImageView)findViewById(R.id.imageView);

        pre.setOnClickListener(btnPreListener);
        next.setOnClickListener(btnNextListener);
    }
    private Button.OnClickListener btnPreListener = new Button.OnClickListener()
    {
        public void onClick(View V)
        {
            p--;
            if(p<0)
            {
                p=count-1;
            }
            imageView.setImageResource(imgId[p]);
            setTitle("第"+(p+1)+"/"+"count");
        }
    };
    private Button.OnClickListener btnNextListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            p++;
            if(p==count)
            {
                p=0;
            }
            imageView.setImageResource(imgId[p]);
            setTitle("第"+(p+1)+"/"+"count");
        }
    };
}
