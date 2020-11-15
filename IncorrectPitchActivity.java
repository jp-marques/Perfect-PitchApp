package com.example.perfectpitch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class IncorrectPitchActivity extends AppCompatActivity {

    //String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Button backBtn;
    Button nextBtn;

    TextView answer;

    PitchActivity idk = new PitchActivity();
    ChordsActivity idk2 = new ChordsActivity();

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void nextBtn() {
        Intent intent = new Intent(this, PitchActivity.class);
        startActivity(intent);
    }

    Random rand = new Random();

    @SuppressLint("SetTextI18n")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect);

        answer = (TextView) findViewById(R.id.incorrectTxt);
        answer.setText("Incorrect! Better luck next time.");

        backBtn = (Button) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //idk.pitchNum = rand.nextInt(11);
                openMenu();
            }
        });

        nextBtn = (Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idk.pitchNum = rand.nextInt(11);
                idk2.chordNum = rand.nextInt(59);
                nextBtn();
            }
        });
    }
   /* public int random (){
        idk.pitchNum = rand.nextInt(11);
        return idk.pitchNum;
    } */
}