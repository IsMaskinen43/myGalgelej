
package com.example.mygalgeleg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Galgelogik spil;
    Button btn_enter;
    TextView textView_Geuss_Letters;
    EditText inputField;
    TextView visibelWord;
    static boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_Geuss_Letters = findViewById(R.id.text_Geuss);
        btn_enter = findViewById(R.id.buton_Enter);
        btn_enter.setOnClickListener(this);

        inputField = findViewById(R.id.text_input);
        spil = new Galgelogik();
        visibelWord = findViewById(R.id.text_Output);

    }


    public void changeImage (int x){
        ImageView image = findViewById(R.id.image_galje);
        int id;
        switch (x){
            case 1:
                id = R.drawable.forkert1;
                break;
            case 2:
                id = R.drawable.forkert2;
                break;
            case 3:
                id = R.drawable.forkert3;
                break;
            case 4:
                id = R.drawable.forkert4;
                break;
            case 5:
                id = R.drawable.forkert5;
                break;
            case 6:
                id = R.drawable.forkert6;
                break;
            default:
                id = R.drawable.galge;
                break;
        }
        image.setImageResource(id);

    }

     @Override
    public void onClick(View view) {
        if(view == btn_enter){
            turn(inputField.getText().toString());
        }
    }

    public void turn(String geuss){

        // if(geuss.length() > 1){
        //  if(geuss == spil.getOrdet()){

        //}
        //}else {
        spil.gætBogstav(geuss);
        //}
        String letters = "Brugte bogstaver: ";
        for(String s : spil.getBrugteBogstaver()){
            letters = letters + " " + s;
        }
        visibelWord.setText(spil.getSynligtOrd());
        textView_Geuss_Letters.setText(letters);
        changeImage(spil.getAntalForkerteBogstaver());
        if(spil.erSpilletSlut()){
            Intent endsceen = new Intent(this, Endscreen.class);

            if(!spil.erSpilletVundet()){
                endsceen.putExtra("EXTRA_MESSAGE","Tabt");
            }else{
                endsceen.putExtra("EXTRA_MESSAGE","Vundet");
            }

            startActivity(endsceen);
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void saveData() {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("geuss_letters", textView_Geuss_Letters.getText().toString());
        editor.putString("word",spil.getOrdet());
        editor.apply();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void loadData() {
        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        String word = sharedPref.getString("word","");
        String geuss_letters = sharedPref.getString("geuss_letters", "");

        spil.nulstil();
        spil.setWord(word);
        for(String l : geuss_letters.split(" ")){
            turn(l);
        }


    }

}