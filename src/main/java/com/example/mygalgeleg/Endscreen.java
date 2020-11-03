package com.example.mygalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Endscreen extends AppCompatActivity {
    TextView winOrNha;
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

    }
}