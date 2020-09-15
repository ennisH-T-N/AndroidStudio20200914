package com.example.finalwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splashscreen extends AppCompatActivity {

    private ImageView pst,psn,psh,psf1,psf2;
    Animation pst_set,psn_set,psh_set,psf1_set,psf2_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        pst = (ImageView)findViewById(R.id.pst);
        psn = (ImageView)findViewById(R.id.psn);
        psh = (ImageView)findViewById(R.id.psh);
        psf1 = (ImageView)findViewById(R.id.psf1);
        psf2 = (ImageView)findViewById(R.id.psf2);

        pst_set = AnimationUtils.loadAnimation(this,R.anim.pst_set);
        psn_set = AnimationUtils.loadAnimation(this,R.anim.psn_set);
        psh_set = AnimationUtils.loadAnimation(this,R.anim.psh_set);
        psf1_set = AnimationUtils.loadAnimation(this,R.anim.psf1_set);
        psf2_set = AnimationUtils.loadAnimation(this,R.anim.psf2_set);


        pst.setAnimation(pst_set);
        psn.setAnimation(psn_set);
        psh.setAnimation(psh_set);
        psf1.setAnimation(psf1_set);
        psf2.setAnimation(psf2_set);


         new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent = new Intent(Splashscreen.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },4000);


    }
}
