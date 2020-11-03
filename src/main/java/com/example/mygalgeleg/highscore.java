package com.example.mygalgeleg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://guides.codepath.com/android/using-the-recyclerview
public class highscore extends AppCompatActivity {
    RecyclerView rc;
    public static List<List<String>> scoreBoard = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        scoreBoard.add(Arrays.asList("Bo", "2"));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
       // rc = findViewById(R.id.higscore_rview);
        rc = new RecyclerView(this);
        highscoreAdapter adapter = new highscoreAdapter(scoreBoard);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        setContentView(rc);

    }

    protected void onStart(){
        super.onStart();
    }

}