package com.example.meirogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //id:restartButtonのボタンをrestartButtonという変数に代入する
        Button restartButton = (Button)findViewById(R.id.restartButton);

        //restartButtonをクリック(onClick)したときの処理
        restartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //restartButtonをクリックしたときに呼び出される処理

                //ゲーム画面(MainActivity)に遷移する
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //id:scoreLabelのTextViewをscoreLabelという変数に代入する
        TextView scoreLabel = (TextView)findViewById(R.id.scoreLabel);
        //スコアの取得
        int score = getIntent().getIntExtra("SCORE", 0);
        //スコアの表示
        scoreLabel.setText(score + "");
    }
}