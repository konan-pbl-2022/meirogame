package com.example.meirogame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
    private int i = 9, j = 8;
    private int point = 0;
    //仮壁
    int[][] wall = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,1,3,0,0,1,0,0,0,1,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,1,3,1,0,1,2,1,0,1},
            {1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,0,0,0,0,0,2,1,0,0,2,1},
            {1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,0,2,0,0,1,2,0,0,1,0,1,3,1,0,1},
            {1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1},
            {1,3,0,0,1,0,1,0,0,0,1,3,1,0,1,0,1},
            {1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,1,0,1,2,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1},
            {1,0,1,0,0,2,0,0,1,3,1,2,1,0,0,2,1},
            {1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1},
            {1,0,1,0,0,0,0,0,1,0,1,2,1,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1},
            {1,0,0,0,2,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id:upbuttonのボタンをupButtonという変数に代入する
        ImageButton upButton = (ImageButton)findViewById(R.id.Upbutton);
        ImageButton downButton = (ImageButton)findViewById(R.id.Downbutton);
        ImageButton leftButton = (ImageButton)findViewById(R.id.Leftbutton);
        ImageButton rightButton = (ImageButton)findViewById(R.id.Rightbutton);
        //ImageView Map = (ImageView) findViewById(R.id.Map);
        final ImageView Map = (ImageView) findViewById(R.id.Map);
        Map.layout(0, 0, Map.getWidth(), Map.getHeight());
        //buttonをクリック（onclick）したときの処理
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ycounter +=270;
                i -= 1;
                if(wall[i][j]==1) {
                    ycounter -= 270;
                    i += 1;
                }
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();
                if ((wall[i][j] == 2) || (wall[i][j] == 3)) {
                    point += 1;
                    wall[i][j] = 0;
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                Map.layout(left, top, right, bottom);
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ycounter -=270;
                i += 1;
                if(wall[i][j]==1) {
                    ycounter += 270;
                    i -= 1;
                }
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();
                if ((wall[i][j] == 2) || (wall[i][j] == 3)) {
                    point += 1;
                    wall[i][j] = 0;
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                Map.layout(left, top, right, bottom);
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                xcounter +=270;
                j -= 1;
                if(wall[i][j]==1) {
                    xcounter -= 270;
                    j += 1;
                }
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();
                if ((wall[i][j] == 2) || (wall[i][j] == 3)) {
                    point += 1;
                    wall[i][j] = 0;
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                Map.layout(left, top, right, bottom);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                xcounter -=270;
                j += 1;
                if(wall[i][j]==1) {
                    xcounter += 270;
                    j -= 1;
                }
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();
                if ((wall[i][j] == 2) || (wall[i][j] == 3)) {
                    point += 1;
                    wall[i][j] = 0;
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                Map.layout(left, top, right, bottom);
            }
        });

        final int score = getIntent().getIntExtra("SCORE", point);//スコアの変数（仮）
    }
}