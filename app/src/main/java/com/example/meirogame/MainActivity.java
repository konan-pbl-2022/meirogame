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
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
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

    private int xcounter = 0;
    private int ycounter = 0;
    private int cxcounter = 0;
    private int cycounter = 0;

    private int k = 0;
    private int l = 0;
    private int [] cx = {100,-350,100,-900,-650,1200,2300,1200,2300,1200,1750};
    private int [] cy = {1000,1500,-100,-100,2600,1500,1500,2050,-700,-700,-1200};
    private int [] ax = {1200,700,700,-1500,-1500,-950,1750};
    private int [] ay = {400,-1200,1500,400,-1750,-1750,-100};

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
        final ImageView candy0 = (ImageView) findViewById(R.id.candy0);
        candy0.layout(0, 0, candy0.getWidth(), candy0.getHeight());
        final ImageView candy1 = (ImageView) findViewById(R.id.candy1);
        candy1.layout(0, 0, candy1.getWidth(), candy1.getHeight());
        final ImageView candy2 = (ImageView) findViewById(R.id.candy2);
        candy2.layout(0, 0, candy2.getWidth(), candy2.getHeight());
        final ImageView candy3 = (ImageView) findViewById(R.id.candy3);
        candy3.layout(0, 0, candy3.getWidth(), candy3.getHeight());
        final ImageView candy4 = (ImageView) findViewById(R.id.candy4);
        candy4.layout(0, 0, candy4.getWidth(), candy4.getHeight());
        final ImageView candy5 = (ImageView) findViewById(R.id.candy5);
        candy5.layout(0, 0, candy5.getWidth(), candy5.getHeight());
        final ImageView candy6 = (ImageView) findViewById(R.id.candy6);
        candy6.layout(0, 0, candy6.getWidth(), candy6.getHeight());
        final ImageView candy7 = (ImageView) findViewById(R.id.candy7);
        candy7.layout(0, 0, candy7.getWidth(), candy7.getHeight());
        final ImageView candy8 = (ImageView) findViewById(R.id.candy8);
        candy8.layout(0, 0, candy8.getWidth(), candy8.getHeight());
        final ImageView candy9 = (ImageView) findViewById(R.id.candy9);
        candy9.layout(0, 0, candy9.getWidth(), candy9.getHeight());
        final ImageView candy10 = (ImageView) findViewById(R.id.candy10);
        candy10.layout(0, 0, candy10.getWidth(), candy10.getHeight());
        final ImageView ame0 = (ImageView) findViewById(R.id.ame0);
        ame0.layout(0, 0, ame0.getWidth(), ame0.getHeight());
        final ImageView ame1 = (ImageView) findViewById(R.id.ame1);
        ame1.layout(0, 0, ame1.getWidth(), ame1.getHeight());
        final ImageView ame2 = (ImageView) findViewById(R.id.ame2);
        ame2.layout(0, 0, ame2.getWidth(), ame2.getHeight());
        final ImageView ame3 = (ImageView) findViewById(R.id.ame3);
        ame3.layout(0, 0, ame3.getWidth(), ame3.getHeight());
        final ImageView ame4 = (ImageView) findViewById(R.id.ame4);
        ame4.layout(0, 0, ame4.getWidth(), ame4.getHeight());
        final ImageView ame5 = (ImageView) findViewById(R.id.ame5);
        ame5.layout(0, 0, ame5.getWidth(), ame5.getHeight());
        final ImageView ame6 = (ImageView) findViewById(R.id.ame6);
        ame5.layout(0, 0, ame6.getWidth(), ame6.getHeight());

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

                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);

                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();
                if (wall[i][j] == 2) {
                    point += 1;
                    wall[i][j] = 0;
                    if((i==11)&&(j==7)){
                        cx[0]=10000;
                        cy[0]=10000;
                    }else if((i==13)&&(j==5)){
                        cx[1]=10000;
                        cy[1]=10000;
                    }else if((i==7)&&(j==7)){
                        cx[2]=10000;
                        cy[2]=10000;
                    }else if((i==7)&&(j==3)){
                        cx[3]=10000;
                        cy[3]=10000;
                    }else if((i==17)&&(j==4)){
                        cx[4]=10000;
                        cy[4]=10000;
                    }else if((i==13)&&(j==11)){
                        cx[5]=10000;
                        cy[5]=10000;
                    }else if((i==13)&&(j==15)){
                        cx[6]=10000;
                        cy[6]=10000;
                    }else if((i==15)&&(j==11)){
                        cx[7]=10000;
                        cy[7]=10000;
                    }else if((i==5)&&(j==15)){
                        cx[8]=10000;
                        cy[8]=10000;
                    }else if((i==5)&&(j==11)){
                        cx[9]=10000;
                        cy[9]=10000;
                    }else if((i==3)&&(j==13)){
                        cx[10]=10000;
                        cy[10]=10000;
                    }
                }else if (wall[i][j] == 3) {
                    point += 2;
                    wall[i][j] = 0;
                    if((i==9)&&(j==11)){
                        ax[0]=10000;
                        ay[0]=10000;
                    }else if((i==3)&&(j==9)){
                        ax[1]=10000;
                        ay[1]=10000;
                    }else if((i==13)&&(j==9)){
                        ax[2]=10000;
                        ay[2]=10000;
                    }else if((i==9)&&(j==1)){
                        ax[3]=10000;
                        ay[3]=10000;
                    }else if((i==1)&&(j==1)){
                        ax[4]=10000;
                        ay[4]=10000;
                    }else if((i==1)&&(j==3)){
                        ax[5]=10000;
                        ay[5]=10000;
                    }else if((i==7)&&(j==13)){
                        ax[6]=10000;
                        ay[6]=10000;
                    }
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);
                
                int cright = xcounter+candy0.getWidth();
                int cbottom = ycounter + candy0.getHeight();
                int aright = xcounter+ame0.getWidth();
                int abottom = ycounter + ame0.getHeight();
                ame0.layout(left + ax[0], top + ay[0], aright + ax[0], abottom + ay[0]);
                ame1.layout(left + ax[1], top + ay[1], aright + ax[1], abottom + ay[1]);
                ame2.layout(left + ax[2], top + ay[2], aright + ax[2], abottom + ay[2]);
                ame3.layout(left + ax[3], top + ay[3], aright + ax[3], abottom + ay[3]);
                ame4.layout(left + ax[4], top + ay[4], aright + ax[4], abottom + ay[4]);
                ame5.layout(left + ax[5], top + ay[5], aright + ax[5], abottom + ay[5]);
                ame6.layout(left + ax[6], top + ay[6], aright + ax[6], abottom + ay[6]);

                candy0.layout(left + cx[0], top + cy[0], cright + cx[0], cbottom + cy[0]);
                candy1.layout(left + cx[1], top + cy[1], cright + cx[1], cbottom + cy[1]);
                candy2.layout(left + cx[2], top + cy[2], cright + cx[2], cbottom + cy[2]);
                candy3.layout(left + cx[3], top + cy[3], cright + cx[3], cbottom + cy[3]);
                candy4.layout(left + cx[4], top + cy[4], cright + cx[4], cbottom + cy[4]);
                candy5.layout(left + cx[5], top + cy[5], cright + cx[5], cbottom + cy[5]);
                candy6.layout(left + cx[6], top + cy[6], cright + cx[6], cbottom + cy[6]);
                candy7.layout(left + cx[7], top + cy[7], cright + cx[7], cbottom + cy[7]);
                candy8.layout(left + cx[8], top + cy[8], cright + cx[8], cbottom + cy[8]);
                candy9.layout(left + cx[9], top + cy[9], cright + cx[9], cbottom + cy[9]);
                candy10.layout(left + cx[10], top + cy[10], cright + cx[10], cbottom + cy[10]);

                Map.layout(left-2000, top-2000, right-2000, bottom-2000);
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

                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);

                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter + Map.getHeight();
                if (wall[i][j] == 2) {
                    point += 1;
                    wall[i][j] = 0;
                    if((i==11)&&(j==7)){
                        cx[0]=10000;
                        cy[0]=10000;
                    }else if((i==13)&&(j==5)){
                        cx[1]=10000;
                        cy[1]=10000;
                    }else if((i==7)&&(j==7)){
                        cx[2]=10000;
                        cy[2]=10000;
                    }else if((i==7)&&(j==3)){
                        cx[3]=10000;
                        cy[3]=10000;
                    }else if((i==17)&&(j==4)){
                        cx[4]=10000;
                        cy[4]=10000;
                    }else if((i==13)&&(j==11)){
                        cx[5]=10000;
                        cy[5]=10000;
                    }else if((i==13)&&(j==15)){
                        cx[6]=10000;
                        cy[6]=10000;
                    }else if((i==15)&&(j==11)){
                        cx[7]=10000;
                        cy[7]=10000;
                    }else if((i==5)&&(j==15)){
                        cx[8]=10000;
                        cy[8]=10000;
                    }else if((i==5)&&(j==11)){
                        cx[9]=10000;
                        cy[9]=10000;
                    }else if((i==3)&&(j==13)){
                        cx[10]=10000;
                        cy[10]=10000;
                    }
                }else if (wall[i][j] == 3) {
                    point += 2;
                    wall[i][j] = 0;
                    if((i==9)&&(j==11)){
                        ax[0]=10000;
                        ay[0]=10000;
                    }else if((i==3)&&(j==9)){
                        ax[1]=10000;
                        ay[1]=10000;
                    }else if((i==13)&&(j==9)){
                        ax[2]=10000;
                        ay[2]=10000;
                    }else if((i==9)&&(j==1)){
                        ax[3]=10000;
                        ay[3]=10000;
                    }else if((i==1)&&(j==1)){
                        ax[4]=10000;
                        ay[4]=10000;
                    }else if((i==1)&&(j==3)){
                        ax[5]=10000;
                        ay[5]=10000;
                    }else if((i==7)&&(j==13)){
                        ax[6]=10000;
                        ay[6]=10000;
                    }
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                int cright = xcounter+candy0.getWidth();
                int cbottom = ycounter + candy0.getHeight();
                int aright = xcounter+ame0.getWidth();
                int abottom = ycounter + ame0.getHeight();
                ame0.layout(left + ax[0], top + ay[0], aright + ax[0], abottom + ay[0]);
                ame1.layout(left + ax[1], top + ay[1], aright + ax[1], abottom + ay[1]);
                ame2.layout(left + ax[2], top + ay[2], aright + ax[2], abottom + ay[2]);
                ame3.layout(left + ax[3], top + ay[3], aright + ax[3], abottom + ay[3]);
                ame4.layout(left + ax[4], top + ay[4], aright + ax[4], abottom + ay[4]);
                ame5.layout(left + ax[5], top + ay[5], aright + ax[5], abottom + ay[5]);
                ame6.layout(left + ax[6], top + ay[6], aright + ax[6], abottom + ay[6]);

                candy0.layout(left + cx[0], top + cy[0], cright + cx[0], cbottom + cy[0]);
                candy1.layout(left + cx[1], top + cy[1], cright + cx[1], cbottom + cy[1]);
                candy2.layout(left + cx[2], top + cy[2], cright + cx[2], cbottom + cy[2]);
                candy3.layout(left + cx[3], top + cy[3], cright + cx[3], cbottom + cy[3]);
                candy4.layout(left + cx[4], top + cy[4], cright + cx[4], cbottom + cy[4]);
                candy5.layout(left + cx[5], top + cy[5], cright + cx[5], cbottom + cy[5]);
                candy6.layout(left + cx[6], top + cy[6], cright + cx[6], cbottom + cy[6]);
                candy7.layout(left + cx[7], top + cy[7], cright + cx[7], cbottom + cy[7]);
                candy8.layout(left + cx[8], top + cy[8], cright + cx[8], cbottom + cy[8]);
                candy9.layout(left + cx[9], top + cy[9], cright + cx[9], cbottom + cy[9]);
                candy10.layout(left + cx[10], top + cy[10], cright + cx[10], cbottom + cy[10]);

                Map.layout(left-2000, top-2000, right-2000, bottom-2000);
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

                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);

                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();
                if (wall[i][j] == 2) {
                    point += 1;
                    wall[i][j] = 0;
                    if((i==11)&&(j==7)){
                        cx[0]=10000;
                        cy[0]=10000;
                    }else if((i==13)&&(j==5)){
                        cx[1]=10000;
                        cy[1]=10000;
                    }else if((i==7)&&(j==7)){
                        cx[2]=10000;
                        cy[2]=10000;
                    }else if((i==7)&&(j==3)){
                        cx[3]=10000;
                        cy[3]=10000;
                    }else if((i==17)&&(j==4)){
                        cx[4]=10000;
                        cy[4]=10000;
                    }else if((i==13)&&(j==11)){
                        cx[5]=10000;
                        cy[5]=10000;
                    }else if((i==13)&&(j==15)){
                        cx[6]=10000;
                        cy[6]=10000;
                    }else if((i==15)&&(j==11)){
                        cx[7]=10000;
                        cy[7]=10000;
                    }else if((i==5)&&(j==15)){
                        cx[8]=10000;
                        cy[8]=10000;
                    }else if((i==5)&&(j==11)){
                        cx[9]=10000;
                        cy[9]=10000;
                    }else if((i==3)&&(j==13)){
                        cx[10]=10000;
                        cy[10]=10000;
                    }
                }else if (wall[i][j] == 3) {
                    point += 2;
                    wall[i][j] = 0;
                    if((i==9)&&(j==11)){
                        ax[0]=10000;
                        ay[0]=10000;
                    }else if((i==3)&&(j==9)){
                        ax[1]=10000;
                        ay[1]=10000;
                    }else if((i==13)&&(j==9)){
                        ax[2]=10000;
                        ay[2]=10000;
                    }else if((i==9)&&(j==1)){
                        ax[3]=10000;
                        ay[3]=10000;
                    }else if((i==1)&&(j==1)){
                        ax[4]=10000;
                        ay[4]=10000;
                    }else if((i==1)&&(j==3)){
                        ax[5]=10000;
                        ay[5]=10000;
                    }else if((i==7)&&(j==13)){
                        ax[6]=10000;
                        ay[6]=10000;
                    }
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                int cright = xcounter+candy0.getWidth();
                int cbottom = ycounter + candy0.getHeight();
                int aright = xcounter+ame0.getWidth();
                int abottom = ycounter + ame0.getHeight();
                ame0.layout(left + ax[0], top + ay[0], aright + ax[0], abottom + ay[0]);
                ame1.layout(left + ax[1], top + ay[1], aright + ax[1], abottom + ay[1]);
                ame2.layout(left + ax[2], top + ay[2], aright + ax[2], abottom + ay[2]);
                ame3.layout(left + ax[3], top + ay[3], aright + ax[3], abottom + ay[3]);
                ame4.layout(left + ax[4], top + ay[4], aright + ax[4], abottom + ay[4]);
                ame5.layout(left + ax[5], top + ay[5], aright + ax[5], abottom + ay[5]);
                ame6.layout(left + ax[6], top + ay[6], aright + ax[6], abottom + ay[6]);

                candy0.layout(left + cx[0], top + cy[0], cright + cx[0], cbottom + cy[0]);
                candy1.layout(left + cx[1], top + cy[1], cright + cx[1], cbottom + cy[1]);
                candy2.layout(left + cx[2], top + cy[2], cright + cx[2], cbottom + cy[2]);
                candy3.layout(left + cx[3], top + cy[3], cright + cx[3], cbottom + cy[3]);
                candy4.layout(left + cx[4], top + cy[4], cright + cx[4], cbottom + cy[4]);
                candy5.layout(left + cx[5], top + cy[5], cright + cx[5], cbottom + cy[5]);
                candy6.layout(left + cx[6], top + cy[6], cright + cx[6], cbottom + cy[6]);
                candy7.layout(left + cx[7], top + cy[7], cright + cx[7], cbottom + cy[7]);
                candy8.layout(left + cx[8], top + cy[8], cright + cx[8], cbottom + cy[8]);
                candy9.layout(left + cx[9], top + cy[9], cright + cx[9], cbottom + cy[9]);
                candy10.layout(left + cx[10], top + cy[10], cright + cx[10], cbottom + cy[10]);

                Map.layout(left-2000, top-2000, right-2000, bottom-2000);
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

                TranslateAnimation translate = new TranslateAnimation(0, 10, 0, 0);
                // 1000ms間
                translate.setDuration(500);
                // 2回繰り返す
                translate.setInterpolator(new CycleInterpolator(1));
                // アニメーションスタート
                dog.startAnimation(translate);
                
                //画像の横縦幅はそのまま維持
                int left = xcounter;
                int top = ycounter;
                int right = xcounter+Map.getWidth();
                int bottom = ycounter+Map.getHeight();
                if (wall[i][j] == 2) {
                    point += 1;
                    wall[i][j] = 0;
                    if((i==11)&&(j==7)){
                        cx[0]=10000;
                        cy[0]=10000;
                    }else if((i==13)&&(j==5)){
                        cx[1]=10000;
                        cy[1]=10000;
                    }else if((i==7)&&(j==7)){
                        cx[2]=10000;
                        cy[2]=10000;
                    }else if((i==7)&&(j==3)){
                        cx[3]=10000;
                        cy[3]=10000;
                    }else if((i==17)&&(j==4)){
                        cx[4]=10000;
                        cy[4]=10000;
                    }else if((i==13)&&(j==11)){
                        cx[5]=10000;
                        cy[5]=10000;
                    }else if((i==13)&&(j==15)){
                        cx[6]=10000;
                        cy[6]=10000;
                    }else if((i==15)&&(j==11)){
                        cx[7]=10000;
                        cy[7]=10000;
                    }else if((i==5)&&(j==15)){
                        cx[8]=10000;
                        cy[8]=10000;
                    }else if((i==5)&&(j==11)){
                        cx[9]=10000;
                        cy[9]=10000;
                    }else if((i==3)&&(j==13)){
                        cx[10]=10000;
                        cy[10]=10000;
                    }
                }else if (wall[i][j] == 3) {
                    point += 2;
                    wall[i][j] = 0;
                    if((i==9)&&(j==11)){
                        ax[0]=10000;
                        ay[0]=10000;
                    }else if((i==3)&&(j==9)){
                        ax[1]=10000;
                        ay[1]=10000;
                    }else if((i==13)&&(j==9)){
                        ax[2]=10000;
                        ay[2]=10000;
                    }else if((i==9)&&(j==1)){
                        ax[3]=10000;
                        ay[3]=10000;
                    }else if((i==1)&&(j==1)){
                        ax[4]=10000;
                        ay[4]=10000;
                    }else if((i==1)&&(j==3)){
                        ax[5]=10000;
                        ay[5]=10000;
                    }else if((i==7)&&(j==13)){
                        ax[6]=10000;
                        ay[6]=10000;
                    }
                }
                System.out.println("score");
                System.out.println("得点"+point);
                System.out.println("壁判定"+wall[i][j]);

                int cright = xcounter+candy0.getWidth();
                int cbottom = ycounter + candy0.getHeight();
                int aright = xcounter+ame0.getWidth();
                int abottom = ycounter + ame0.getHeight();
                ame0.layout(left + ax[0], top + ay[0], aright + ax[0], abottom + ay[0]);
                ame1.layout(left + ax[1], top + ay[1], aright + ax[1], abottom + ay[1]);
                ame2.layout(left + ax[2], top + ay[2], aright + ax[2], abottom + ay[2]);
                ame3.layout(left + ax[3], top + ay[3], aright + ax[3], abottom + ay[3]);
                ame4.layout(left + ax[4], top + ay[4], aright + ax[4], abottom + ay[4]);
                ame5.layout(left + ax[5], top + ay[5], aright + ax[5], abottom + ay[5]);
                ame6.layout(left + ax[6], top + ay[6], aright + ax[6], abottom + ay[6]);

                candy0.layout(left + cx[0], top + cy[0], cright + cx[0], cbottom + cy[0]);
                candy1.layout(left + cx[1], top + cy[1], cright + cx[1], cbottom + cy[1]);
                candy2.layout(left + cx[2], top + cy[2], cright + cx[2], cbottom + cy[2]);
                candy3.layout(left + cx[3], top + cy[3], cright + cx[3], cbottom + cy[3]);
                candy4.layout(left + cx[4], top + cy[4], cright + cx[4], cbottom + cy[4]);
                candy5.layout(left + cx[5], top + cy[5], cright + cx[5], cbottom + cy[5]);
                candy6.layout(left + cx[6], top + cy[6], cright + cx[6], cbottom + cy[6]);
                candy7.layout(left + cx[7], top + cy[7], cright + cx[7], cbottom + cy[7]);
                candy8.layout(left + cx[8], top + cy[8], cright + cx[8], cbottom + cy[8]);
                candy9.layout(left + cx[9], top + cy[9], cright + cx[9], cbottom + cy[9]);
                candy10.layout(left + cx[10], top + cy[10], cright + cx[10], cbottom + cy[10]);

                Map.layout(left-2000, top-2000, right-2000, bottom-2000);
            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(45000, 100) {
            @Override
            public void onTick(final long millisUntilFinished) {
                final int time = (int)millisUntilFinished /1000;
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        }.start();

        final int score = getIntent().getIntExtra("SCORE", point);//スコアの変数（仮）
    }
}