package com.example.mygalgeleg;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//https://guides.codepath.com/android/using-the-recyclerview
public class highscore extends AppCompatActivity {
    RecyclerView rc;
    public static List<DTOhigscore> scoreBoard;
    private DatabaseHelper dh = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scoreBoard = new ArrayList<>();
        Cursor data = dh.getData();
        while(data.moveToNext()){
            DTOhigscore dto = new DTOhigscore(data.getString(1),data.getString(2),data.getInt(3));
            System.out.println(dto.toString());
            scoreBoard.add(dto);
        }

        setContentView(R.layout.activity_highscore);
       // rc = findViewById(R.id.higscore_rview);
        rc = new RecyclerView(this);
        highscoreAdapter adapter = new highscoreAdapter(scoreBoard);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        setContentView(rc);

    }

    @Override
    protected void onStop() {
        super.onStop();
        rc = null;


    }
}