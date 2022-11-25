package com.example.meirogame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    private int xcounter = -2000;
    private int ycounter = -2000;
    Handler mHandler;
    private TextView countTextView;
    private ImageView map;

    private int left, right, top, bottom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id:upbuttonのボタンをupButtonという変数に代入する
        ImageButton upButton = (ImageButton)findViewById(R.id.Upbutton);
        ImageButton downButton = (ImageButton)findViewById(R.id.Downbutton);
        ImageButton leftButton = (ImageButton)findViewById(R.id.Leftbutton);
        ImageButton rightButton = (ImageButton)findViewById(R.id.Rightbutton);
        countTextView = (TextView)findViewById(R.id.count);

        map = (ImageView) findViewById(R.id.Map);
        map.layout(left, right, map.getWidth(), map.getHeight());

        //buttonをクリック（onclick）したときの処理
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ycounter +=250;
                //画像の横縦幅はそのまま維持
                left = xcounter;
                top = ycounter;
                right = xcounter + map.getWidth();
                bottom = ycounter + map.getHeight();
                System.out.println(ycounter);

//                System.out.println("L/R :" + left + "/"+ right);
//                System.out.println("T/B :" + top + "/"+ bottom);

                map.layout(left, top, right, bottom);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ycounter -=250;
                //画像の横縦幅はそのまま維持
                left = xcounter;
                top = ycounter;
                right = xcounter+map.getWidth();
                bottom = ycounter + map.getHeight();
                System.out.println("L/R :" + left + "/"+ right);
                System.out.println("T/B :" + top + "/"+ bottom);

                map.layout(left, top, right, bottom);

            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                xcounter +=280;
                //画像の横縦幅はそのまま維持
                left = xcounter;
                top = ycounter;
                right = xcounter+map.getWidth();
                bottom = ycounter+map.getHeight();

//                System.out.println("L/R :" + left + "/"+ right);
//                System.out.println("T/B :" + top + "/"+ bottom);

                map.layout(left, top, right, bottom);
            }
        });

      rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                xcounter -=280;
                //画像の横縦幅はそのまま維持
                left = xcounter;
                top = ycounter;
                right = xcounter+map.getWidth();
                bottom = ycounter+map.getHeight();

//                System.out.println("L/R :" + left + "/"+ right);
//                System.out.println("T/B :" + top + "/"+ bottom);
            }
        });

//        mHandler = new Handler();
//        // もしくはLooperでメインスレッドを指定して生成
//        mHandler = new Handler(Looper.getMainLooper());
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                /* カウントダウン */
//                CountDownTimer countDownTimer = new CountDownTimer(10000, 100) {
//                    @Override
//                    public void onTick(final long millisUntilFinished) {
//                        final int time = (int)millisUntilFinished /1000;
////                        countTextView.setText("あと" + String.valueOf(time) + "秒");
//                    }
//                    @Override
//                    public void onFinish() {
//                        finish();
//                    }
//                }.start();
//            }
//        });

      /* カウントダウン */
        CountDownTimer countDownTimer = new CountDownTimer(45000, 100) {
            @Override
            public void onTick(final long millisUntilFinished) {
                final int time = (int)millisUntilFinished /1000;
//                countTextView.setText("あと" + String.valueOf(time) + "秒");
                left = xcounter;
                top = ycounter;
                right = xcounter+map.getWidth();
                bottom = ycounter+map.getHeight();
                map.layout(left, top, right, bottom);
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        }.start();

        final int score = getIntent().getIntExtra("SCORE", 0);//スコアの変数（仮）
    }


}