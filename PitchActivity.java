package com.example.perfectpitch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PitchActivity extends AppCompatActivity {

    String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    String[] c = {"C", "B sharp", "B#"};
    String[] cS = {"C#", "Db", "c sharp", "d flat"};
    String[] d = {"D"};
    String[] dS = {"D#", "D sharp", "Eb", "E flat"};
    String[] e = {"E", "F flat", "Fb"};
    String[] f = {"F", "E sharp", "E#"};
    String[] fS = {"F#", "F sharp", "G flat", "Gb"};
    String[] g = {"G"};
    String[] gS = {"G#", "G Sharp", "Ab", "A flat"};
    String[] a = {"A"};
    String[] aS = {"A#", "A sharp", "Bb", "B flat"};
    String[] b = {"B", "c flat", "Cb"};

    String pitchAnswer;
    EditText pitchInput;

    Button submitBtn;
    Button backBtn;
    Button playAgn;

    Boolean correct;

    Random rand = new Random();

    int pitchNum;

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openCorrect() {
        Intent intent = new Intent(this, CorrectPitchActivity.class);
        startActivity(intent);
    }

    public void openIncorrect() {
        Intent intent = new Intent(this, IncorrectPitchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch);

        pitchNum = rand.nextInt(11);

        pitchInput = (EditText) findViewById(R.id.pitch_input);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pitchAnswer = pitchInput.getText().toString();

                //
                // IF STATEMENTS
                //
                if (pitchNum == 0) {

                    if (pitchAnswer.equalsIgnoreCase(c[0]) || pitchAnswer.equalsIgnoreCase(c[1])
                            || pitchAnswer.equalsIgnoreCase(c[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (pitchNum == 1) {

                    if (pitchAnswer.equalsIgnoreCase(cS[0]) || pitchAnswer.equalsIgnoreCase(cS[1])
                            || pitchAnswer.equalsIgnoreCase(cS[2]) || pitchAnswer.equalsIgnoreCase(cS[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (pitchNum == 2) {

                    if (pitchAnswer.equalsIgnoreCase(d[0])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 3) {

                    if (pitchAnswer.equalsIgnoreCase(dS[0]) || pitchAnswer.equalsIgnoreCase(dS[1])
                            || pitchAnswer.equalsIgnoreCase(dS[2]) || pitchAnswer.equalsIgnoreCase(dS[3])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 4) {

                    if (pitchAnswer.equalsIgnoreCase(e[0]) || pitchAnswer.equalsIgnoreCase(e[1])
                            || pitchAnswer.equalsIgnoreCase(e[2])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 5) {

                    if (pitchAnswer.equalsIgnoreCase(f[0]) || pitchAnswer.equalsIgnoreCase(f[1])
                            || pitchAnswer.equalsIgnoreCase(f[2])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 6) {

                    if (pitchAnswer.equalsIgnoreCase(fS[0]) || pitchAnswer.equalsIgnoreCase(fS[1])
                            || pitchAnswer.equalsIgnoreCase(fS[2]) || pitchAnswer.equalsIgnoreCase(fS[3])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 7) {

                    if (pitchAnswer.equalsIgnoreCase(g[0])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 8) {

                    if (pitchAnswer.equalsIgnoreCase(gS[0]) || pitchAnswer.equalsIgnoreCase(gS[1])
                            || pitchAnswer.equalsIgnoreCase(gS[2]) || pitchAnswer.equalsIgnoreCase(gS[3])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 9) {

                    if (pitchAnswer.equalsIgnoreCase(a[0])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                } if (pitchNum == 10) {

                    if (pitchAnswer.equalsIgnoreCase(aS[0]) || pitchAnswer.equalsIgnoreCase(aS[1])
                            || pitchAnswer.equalsIgnoreCase(aS[2]) || pitchAnswer.equalsIgnoreCase(aS[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (pitchNum == 11) {

                    if (pitchAnswer.equalsIgnoreCase(b[0]) || pitchAnswer.equalsIgnoreCase(b[1])
                            || pitchAnswer.equalsIgnoreCase(b[2])) {

                        correct = true;

                    } else {

                        correct = false;


                    }

                }
                //
                // END IF STATEMENTS
                //

                if (correct) {

                    openCorrect();

                } else if (!correct) {

                    openIncorrect();

                }
            }
        });

        backBtn = (Button) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        final MediaPlayer c = MediaPlayer.create(this, R.raw.c3);
        final MediaPlayer cS = MediaPlayer.create(this, R.raw.cs3);
        final MediaPlayer d = MediaPlayer.create (this, R.raw.d3);
        final MediaPlayer dS = MediaPlayer.create (this, R.raw.ds3);
        final MediaPlayer e = MediaPlayer.create (this, R.raw.e3);
        final MediaPlayer f = MediaPlayer.create (this, R.raw.f3);
        final MediaPlayer fS = MediaPlayer.create (this, R.raw.fs3);
        final MediaPlayer g = MediaPlayer.create (this, R.raw.g3);
        final MediaPlayer gS = MediaPlayer.create (this, R.raw.gs3);
        final MediaPlayer a = MediaPlayer.create (this, R.raw.a3);
        final MediaPlayer aS = MediaPlayer.create (this, R.raw.as3);
        final MediaPlayer b = MediaPlayer.create (this, R.raw.b3);

        playAgn = (Button) findViewById(R.id.sound_btn);
        playAgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pitchNum == 0) {
                    c.start();
                } else if (pitchNum == 1) {
                    cS.start();
                } else if (pitchNum == 2) {
                    d.start();
                } else if (pitchNum == 3) {
                    dS.start();
                } else if (pitchNum == 4) {
                    e.start();
                } else if (pitchNum == 5) {
                    f.start();
                } else if (pitchNum == 6) {
                    fS.start();
                } else if (pitchNum == 7) {
                    g.start();
                } else if (pitchNum == 8) {
                    gS.start();
                } else if (pitchNum == 9) {
                    a.start();
                } else if (pitchNum == 10) {
                    aS.start();
                } else if (pitchNum == 11) {
                    b.start();
                }
            }
        });
    }
    public String getCorrect() {
        return notes[pitchNum];
    }
}