
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    IGalgelogik spil;
    Button btn_enter;
    TextView textView_Geuss_Letters;
    EditText inputField;
    TextView visibelWord;
    int fails = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_Geuss_Letters = findViewById(R.id.text_Geuss);
        btn_enter = findViewById(R.id.buton_Enter);
        btn_enter.setOnClickListener(this);

        inputField = findViewById(R.id.text_input);
        spil = Galgelogik.getInstance();
        spil.nulstil();
        getPreferences(MODE_PRIVATE).edit().putString("word", spil.getOrdet()).apply();
        visibelWord = findViewById(R.id.text_Output);

    }

    public void changeImage (int x){
        ImageView image = findViewById(R.id.image_galje);
        int id;
        fails = x;
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
        spil.gætBogstav(geuss);
        String letters = "Brugte bogstaver: ";
        for(String s : spil.getBrugteBogstaver()){
            letters = letters + " " + s;
        }
        visibelWord.setText(spil.getSynligtOrd());
        textView_Geuss_Letters.setText(letters);
        changeImage(spil.getAntalForkerteBogstaver());
        inputField.setText("");

        if(spil.erSpilletSlut()){
            Intent endsceen = new Intent(this, Endscreen.class);
            if(!spil.erSpilletVundet()){
                endsceen.putExtra("EXTRA_MESSAGE","Tabt ordret var: " + spil.getOrdet());
            }else{
                endsceen.putExtra("EXTRA_MESSAGE","Vundet med " + spil.getAntalForkerteBogstaver() + " fejl gæt");
                System.out.println("Username er: "+ LogIn.username);
                DTOhigscore dto = new DTOhigscore(LogIn.username, spil.getOrdet(), spil.getAntalForkerteBogstaver());
                DatabaseHelper db = new DatabaseHelper(this);
                db.addData(dto);
            }
            startActivity(endsceen);
        }

    }

    public void onPause() {
        super.onPause();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("geuss_letters", textView_Geuss_Letters.getText().toString());
        editor.putString("word",spil.getOrdet());
        editor.putString("username", LogIn.username);
        editor.apply();
    }


    public void onDestroy(){
        super.onDestroy();
       this.getPreferences(Context.MODE_PRIVATE).edit().clear().apply();
    }


    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
       // String word = sharedPref.getString("word","");
       // String geuss_letters = sharedPref.getString("geuss_letters", "");

     //   LogIn.username = sharedPref.getString("username","");

      //  spil.nulstil();
        //spil.setWord(word);
        //for(String l : geuss_letters.split(" ")){
        //    turn(l);
        //}


    }

}