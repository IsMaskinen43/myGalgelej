package com.example.mygalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosePlayMode extends AppCompatActivity implements View.OnClickListener {
    Button btn_normal, btn_useWord;
    TextView txtIn;
    Galgelogik spil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_play_mode);
        btn_normal = findViewById(R.id.choose_btn_normal);
       btn_useWord = findViewById(R.id.choose_use_word);
        txtIn  = findViewById(R.id.choose_txt_word);
        btn_useWord.setOnClickListener(this);
        btn_normal.setOnClickListener(this);

        spil = Galgelogik.getInstance();
    }

    @Override
    public void onClick(View view) {

        if(view == btn_useWord){
            spil.setWord(txtIn.getText().toString());
        }
        Intent main = new Intent(this, MainActivity.class);
       startActivity(main);

    }
}