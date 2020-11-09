package com.example.mygalgeleg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    public static String username;
    private Button btn;
    private Button btn_highscore;
    private TextView view_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btn = findViewById(R.id.logIn_Btn_Login);
        btn_highscore = findViewById(R.id.logIn_btn_highscore);
        view_username = findViewById(R.id.logIn_EditTxt_Login);
        btn.setOnClickListener(this);
        btn_highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn){
            username = view_username.getText().toString();
            Intent main = new Intent(this, MainActivity.class);
            this.getPreferences(Context.MODE_PRIVATE).edit().clear().apply();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", LogIn.username).apply();
            startActivity(main);
        } else if(view == btn_highscore){
            Intent hs = new Intent(this, highscore.class);
            this.getPreferences(Context.MODE_PRIVATE).edit().clear().apply();
            startActivity(hs);
        }
    }
}