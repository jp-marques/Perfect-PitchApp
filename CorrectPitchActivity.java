package com.example.perfectpitch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CorrectPitchActivity extends AppCompatActivity {

    Button backBtn;
    Button nextBtn;

    PitchActivity idk = new PitchActivity();
    ChordsActivity idk2 = new ChordsActivity();

    Random rand = new Random();

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void nextBtn() {
        Intent intent = new Intent(this, PitchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        idk.pitchNum = rand.nextInt(11);
        idk2.chordNum = rand.nextInt(59);

        backBtn = (Button) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        nextBtn = (Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBtn();
            }
        });
    }
}