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
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id:upbuttonのボタンをupButtonという変数に代入する
        ImageButton upButton = (ImageButton)findViewById(R.id.Upbutton);
        ImageButton downButton = (ImageButton)findViewById(R.id.Downbutton);
        //ImageView Map = (ImageView) findViewById(R.id.Map);
        final ImageView Map = (ImageView) findViewById(R.id.Map);
        Map.layout(0, 0, Map.getWidth(), Map.getHeight());
        //okbuttonをクリック（onclick）したときの処理
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter +=50;
                //画像の横縦幅はそのまま維持
                int left = 0;
                int top = counter;
                int right = Map.getWidth();
                int bottom = counter + Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter -=50;
                //画像の横縦幅はそのまま維持
                int left = 0;
                int top = counter;
                int right = Map.getWidth();
                int bottom = counter + Map.getHeight();

                Map.layout(left, top, right, bottom);
            }
        });
    }
}