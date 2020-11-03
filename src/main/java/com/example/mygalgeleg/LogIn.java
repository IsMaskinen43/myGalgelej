package com.example.mygalgeleg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    public static String username;
    private Button btn;
    private TextView view_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btn = findViewById(R.id.logIn_Btn_Login);
        view_username = findViewById(R.id.logIn_EditTxt_Login);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == btn){
            
        }
    }
}