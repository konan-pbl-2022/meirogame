package com.example.meirogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int xcounter = 0;
    private int ycounter = 0;
    private int cxcounter = 0;
    private int cycounter = 0;
    private int i = 9;
    private int j = 10;
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

        final int score = getIntent().getIntExtra("SCORE", 0);//スコアの変数（仮）
    }
}