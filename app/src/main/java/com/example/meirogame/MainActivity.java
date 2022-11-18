package com.example.meirogame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int xcounter = -2000;
    private int ycounter = -2000;
    private int i = 9;
    private int j = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id:upbuttonのボタンをupButtonという変数に代入する
        ImageButton upButton = (ImageButton)findViewById(R.id.Upbutton);
        ImageButton downButton = (ImageButton)findViewById(R.id.Downbutton);
        ImageButton leftButton = (ImageButton)findViewById(R.id.Leftbutton);
        ImageButton rightButton = (ImageButton)findViewById(R.id.Rightbutton);
        final ImageView dog = (ImageView) findViewById(R.id.Dog);
        //ImageView Map = (ImageView) findViewById(R.id.Map);
        final ImageView Map = (ImageView) findViewById(R.id.Map);
        Map.layout(0, 0, Map.getWidth(), Map.getHeight());
        //buttonをクリック（onclick）したときの処理
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j--;
                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);
                ycounter +=270;
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j++;
                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);
                ycounter -=270;
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i--;
                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);
                xcounter +=270;
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i++;
                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);
                xcounter -=270;
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });

    }
}