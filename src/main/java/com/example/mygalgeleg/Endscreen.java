package com.example.mygalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Endscreen extends AppCompatActivity implements View.OnClickListener {
    TextView winOrNha;
    Button btn_newGame, btn_highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endscreen);
        Intent intent = getIntent();
        winOrNha  = findViewById(R.id.label_Endscreen);
        winOrNha.setText(intent.getStringExtra("EXTRA_MESSAGE"));
    }

    protected void onResume() {
        super.onResume();
        getPreferences(MODE_PRIVATE).edit().clear().apply();
        btn_highscore = findViewById(R.id.Endscreen_btn_Higscore);
        btn_newGame = findViewById(R.id.endscreen_btn_login);
        btn_newGame.setOnClickListener(this);
        btn_highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn_highscore){
            Intent hs = new Intent(this, highscore.class);
            startActivity(hs);
        }else if (view == btn_newGame){
            Intent hs = new Intent(this, LogIn.class);
            startActivity(hs);
        }
    }
}