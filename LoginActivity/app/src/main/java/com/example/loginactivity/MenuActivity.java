package com.example.loginactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button btn_up[] = new Button[4];
    Button btn_down[] = new Button[4];
    TextView total[] = new TextView[4];

    int up[] = {R.id.btn1_plus, R.id.btn2_plus, R.id.btn3_plus, R.id.btn4_plus};
    int down[] = {R.id.btn1_subtract, R.id.btn2_subtract, R.id.btn3_subtract, R.id.btn4_subtract};
    int number[] = {R.id.tv1_total, R.id.tv2_total, R.id.tv3_total, R.id.tv4_total};

    int e[] = {0, 0, 0, 0};
    String s = "";
    int sum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findView();
    }

    public void Up(View v) {
        for(int i=0;i<btn_up.length; i++) {
            if (v == btn_up[i]) {
                e[i]++;
                s = Integer.toString(e[i]);
                total[i].setText(s);
            }
        }
    }

    public void Down(View v) {
        for(int i=0;i<btn_down.length;i++) {
            if (v==btn_down[i]) {
                if (e[i] > 0) {
                    e[i]--;
                    s = Integer.toString(e[i]);
                    total[i].setText(s);
                }
            }
        }
    }

    public void Enter(View v) {
        for(int i=0; i<e.length;i++) {
            sum=135*e[0]+150*e[1]+90*e[2]+110*e[3];
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("點餐結果");
            builder.setMessage("鮮蔬農夫漢堡:" + e[0] + "份\n" +
                    "鳳梨照燒雞肉漢堡:" + e[1] + "份\n" +
                    "總匯三明治:" + e[2] + "份\n" +
                    "歐風烤豬排三明治:" + e[3] + "份\n"+
                    "總計 = "+sum+" 元 \n");
            builder.setPositiveButton("確定",
                    new DialogInterface.OnClickListener() {
                        // 訊息框裡加一個按鈕
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.cancel();
// 返回點餐畫面
                        }
                    }).show();
            break;
        }
    }

    public void findView() {
        for(int i=0;i<btn_up.length;i++) {
            btn_up[i] = (Button)findViewById(up[i]);
            btn_down[i] = (Button)findViewById(down[i]);
            total[i] = (TextView)findViewById(number[i]);

        }
    }
}
