package com.example.perfectpitch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ChordsActivity extends AppCompatActivity {

    String chordAnswer;
    EditText chordInput;

    Button submitBtn;
    Button backBtn;
    Button playAgn;

    Random rand = new Random();

    //Answers
    //Chords
    String[] cM = {"C major", "B sharp major", "B# major"};
    String[] cSM = {"C# major", "Db major", "c sharp major", "d flat major"};
    String[] dM = {"D major"};
    String[] dSM = {"D# major", "D sharp major", "Eb major", "E flat major"};
    String[] eM = {"E major", "F flat major", "Fb major"};
    String[] fM = {"F major", "E sharp major", "E# major"};
    String[] fSM = {"F# major", "F sharp major", "G flat major", "Gb major"};
    String[] gM = {"G major"};
    String[] gSM = {"G# major", "G Sharp major", "Ab major", "A flat major"};
    String[] aM = {"A major"};
    String[] aSM = {"A# major", "A sharp major", "Bb major", "B flat major"};
    String[] bM = {"B major", "c flat major", "Cb major"};

    String[] cm = {"C minor", "B sharp minor", "B# minor"};
    String[] cSm = {"C# minor", "Db minor", "c sharp minor", "d flat minor"};
    String[] dm = {"D minor"};
    String[] dSm = {"D# minor", "D sharp minor", "Eb minor", "E flat minor"};
    String[] em = {"E minor", "F flat minor", "Fb minor"};
    String[] fm = {"F minor", "E sharp minor", "E# minor"};
    String[] fSm = {"F# minor", "F sharp minor", "G flat minor", "Gb minor"};
    String[] gm = {"G minor"};
    String[] gSm = {"G# minor", "G Sharp minor", "Ab minor", "A flat minor"};
    String[] am = {"A minor"};
    String[] aSm = {"A# minor", "A sharp minor", "Bb minor", "B flat minor"};
    String[] bm = {"B minor", "c flat minor", "Cb minor"};

    String[] c7 = {"C Dominant 7th", "B sharp Dominant 7th", "B# Dominant 7th"};
    String[] cS7 = {"C# Dominant 7th", "Db Dominant 7th", "c sharp Dominant 7th", "d flat Dominant 7th"};
    String[] d7 = {"D Dominant 7th"};
    String[] dS7 = {"D# Dominant 7th", "D sharp Dominant 7th", "Eb Dominant 7th", "E flat Dominant 7th"};
    String[] e7 = {"E Dominant 7th", "F flat Dominant 7th", "Fb Dominant 7th"};
    String[] f7 = {"F Dominant 7th", "E sharp Dominant 7th", "E# Dominant 7th"};
    String[] fS7 = {"F# Dominant 7th", "F sharp Dominant 7th", "G flat Dominant 7th", "Gb Dominant 7th"};
    String[] g7 = {"G Dominant 7th"};
    String[] gS7 = {"G# Dominant 7th", "G Sharp Dominant 7th", "Ab Dominant 7th", "A flat Dominant 7th"};
    String[] a7 = {"A Dominant 7th"};
    String[] aS7 = {"A# Dominant 7th", "A sharp Dominant 7th", "Bb Dominant 7th", "B flat Dominant 7th"};
    String[] b7 = {"B Dominant 7th", "c flat Dominant 7th", "Cb Dominant 7th"};

    String[] c0 = {"C Diminished", "B sharp Diminished", "B# Diminished"};
    String[] cS0 = {"C# Diminished", "Db Diminished", "c sharp Diminished", "d flat Diminished"};
    String[] d0 = {"D Diminished"};
    String[] dS0 = {"D# Diminished", "D sharp Diminished", "Eb Diminished", "E flat Diminished"};
    String[] e0 = {"E Diminished", "F flat Diminished", "Fb Diminished"};
    String[] f0 = {"F Diminished", "E sharp Diminished", "E# Diminished"};
    String[] fS0 = {"F# Diminished", "F sharp Diminished", "G flat Diminished", "Gb Diminished"};
    String[] g0 = {"G Diminished"};
    String[] gS0 = {"G# Diminished", "G Sharp Diminished", "Ab Diminished", "A flat Diminished"};
    String[] a0 = {"A Diminished"};
    String[] aS0 = {"A# Diminished", "A sharp Diminished", "Bb Diminished", "B flat Diminished"};
    String[] b0 = {"B Diminished", "c flat Diminished", "Cb Diminished"};

    String[] cA = {"C Augmented", "B sharp Augmented", "B# Augmented"};
    String[] cSA = {"C# Augmented", "Db Augmented", "c sharp Augmented", "d flat Augmented"};
    String[] dA = {"D Augmented"};
    String[] dSA = {"D# Augmented", "D sharp Augmented", "Eb Augmented", "E flat Augmented"};
    String[] eA = {"E Augmented", "F flat Augmented", "Fb Augmented"};
    String[] fA = {"F Augmented", "E sharp Augmented", "E# Augmented"};
    String[] fSA = {"F# Augmented", "F sharp Augmented", "G flat Augmented", "Gb Augmented"};
    String[] gA = {"G Augmented"};
    String[] gSA = {"G# Augmented", "G Sharp Augmented", "Ab Augmented", "A flat Augmented"};
    String[] aA = {"A Augmented"};
    String[] aSA = {"A# Augmented", "A sharp Augmented", "Bb Augmented", "B flat Augmented"};
    String[] bA = {"B Augmented", "c flat Augmented", "Cb Augmented"};

    int chordNum;

    Boolean correct;

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openCorrect() {
        Intent intent = new Intent(this, CorrectChordActivity.class);
        startActivity(intent);
    }

    public void openIncorrect() {
        Intent intent = new Intent(this, IncorrectChordActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords);

        chordNum = rand.nextInt(59);

        chordInput = (EditText) findViewById(R.id.chord_input);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chordAnswer = chordInput.getText().toString();

                ///
                ///IF STATEMENTS
                ///
                // Corrections major

                if (chordNum == 0) {

                    if (chordAnswer.equalsIgnoreCase(cM[0]) || chordAnswer.equalsIgnoreCase(cM[1])
                            || chordAnswer.equalsIgnoreCase(cM[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 1) {

                    if (chordAnswer.equalsIgnoreCase(cSM[0]) || chordAnswer.equalsIgnoreCase(cSM[1])
                            || chordAnswer.equalsIgnoreCase(cSM[2]) || chordAnswer.equalsIgnoreCase(cSM[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 2) {

                    if (chordAnswer.equalsIgnoreCase(dM[0])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 3) {

                    if (chordAnswer.equalsIgnoreCase(dSM[0]) || chordAnswer.equalsIgnoreCase(dSM[1])
                            || chordAnswer.equalsIgnoreCase(dSM[2]) || chordAnswer.equalsIgnoreCase(dSM[3])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 4) {

                    if (chordAnswer.equalsIgnoreCase(eM[0]) || chordAnswer.equalsIgnoreCase(eM[1])
                            || chordAnswer.equalsIgnoreCase(eM[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 5) {

                    if (chordAnswer.equalsIgnoreCase(fM[0]) || chordAnswer.equalsIgnoreCase(fM[1])
                            || chordAnswer.equalsIgnoreCase(fM[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 6) {

                    if (chordAnswer.equalsIgnoreCase(fSM[0]) || chordAnswer.equalsIgnoreCase(fSM[1])
                            || chordAnswer.equalsIgnoreCase(fSM[2]) || chordAnswer.equalsIgnoreCase(fSM[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 7) {

                    if (chordAnswer.equalsIgnoreCase(gM[0])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 8) {

                    if (chordAnswer.equalsIgnoreCase(gSM[0]) || chordAnswer.equalsIgnoreCase(gSM[1])
                            || chordAnswer.equalsIgnoreCase(gSM[2]) || chordAnswer.equalsIgnoreCase(gSM[3])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 9) {

                    if (chordAnswer.equalsIgnoreCase(aM[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 10) {

                    if (chordAnswer.equalsIgnoreCase(aSM[0]) || chordAnswer.equalsIgnoreCase(aSM[1])
                            || chordAnswer.equalsIgnoreCase(aSM[2]) || chordAnswer.equalsIgnoreCase(aSM[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 11) {

                    if (chordAnswer.equalsIgnoreCase(bM[0]) || chordAnswer.equalsIgnoreCase(bM[1])
                            || chordAnswer.equalsIgnoreCase(bM[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                }

                // Corrections minor

                if (chordNum == 12) {

                    if (chordAnswer.equalsIgnoreCase(cm[0]) || chordAnswer.equalsIgnoreCase(cm[1])
                            || chordAnswer.equalsIgnoreCase(cm[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 13) {

                    if (chordAnswer.equalsIgnoreCase(cSm[0]) || chordAnswer.equalsIgnoreCase(cSm[1])
                            || chordAnswer.equalsIgnoreCase(cSm[2]) || chordAnswer.equalsIgnoreCase(cSm[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 14) {

                    if (chordAnswer.equalsIgnoreCase(dm[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 15) {

                    if (chordAnswer.equalsIgnoreCase(dSm[0]) || chordAnswer.equalsIgnoreCase(dSm[1])
                            || chordAnswer.equalsIgnoreCase(dSm[2]) || chordAnswer.equalsIgnoreCase(dSm[3])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 16) {

                    if (chordAnswer.equalsIgnoreCase(em[0]) || chordAnswer.equalsIgnoreCase(em[1])
                            || chordAnswer.equalsIgnoreCase(em[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 17) {

                    if (chordAnswer.equalsIgnoreCase(fm[0]) || chordAnswer.equalsIgnoreCase(fm[1])
                            || chordAnswer.equalsIgnoreCase(fm[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 18) {

                    if (chordAnswer.equalsIgnoreCase(fSm[0]) || chordAnswer.equalsIgnoreCase(fSm[1])
                            || chordAnswer.equalsIgnoreCase(fSm[2]) || chordAnswer.equalsIgnoreCase(fSm[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 19) {

                    if (chordAnswer.equalsIgnoreCase(gm[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 20) {

                    if (chordAnswer.equalsIgnoreCase(gSm[0]) || chordAnswer.equalsIgnoreCase(gSm[1])
                            || chordAnswer.equalsIgnoreCase(gSm[2]) || chordAnswer.equalsIgnoreCase(gSm[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 21) {

                    if (chordAnswer.equalsIgnoreCase(am[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 22) {

                    if (chordAnswer.equalsIgnoreCase(aSm[0]) || chordAnswer.equalsIgnoreCase(aSm[1])
                            || chordAnswer.equalsIgnoreCase(aSm[2]) || chordAnswer.equalsIgnoreCase(aSm[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 23) {

                    if (chordAnswer.equalsIgnoreCase(bm[0]) || chordAnswer.equalsIgnoreCase(bm[1])
                            || chordAnswer.equalsIgnoreCase(bm[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                }

                // Corrections dominant

                if (chordNum == 24) {

                    if (chordAnswer.equalsIgnoreCase(c7[0]) || chordAnswer.equalsIgnoreCase(c7[1])
                            || chordAnswer.equalsIgnoreCase(c7[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 25) {

                    if (chordAnswer.equalsIgnoreCase(cS7[0]) || chordAnswer.equalsIgnoreCase(cS7[1])
                            || chordAnswer.equalsIgnoreCase(cS7[2]) || chordAnswer.equalsIgnoreCase(cS7[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 26) {

                    if (chordAnswer.equalsIgnoreCase(d7[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 27) {

                    if (chordAnswer.equalsIgnoreCase(dS7[0]) || chordAnswer.equalsIgnoreCase(dS7[1])
                            || chordAnswer.equalsIgnoreCase(dS7[2]) || chordAnswer.equalsIgnoreCase(dS7[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 28) {

                    if (chordAnswer.equalsIgnoreCase(e7[0]) || chordAnswer.equalsIgnoreCase(e7[1])
                            || chordAnswer.equalsIgnoreCase(e7[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 29) {

                    if (chordAnswer.equalsIgnoreCase(f7[0]) || chordAnswer.equalsIgnoreCase(f7[1])
                            || chordAnswer.equalsIgnoreCase(f7[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 30) {

                    if (chordAnswer.equalsIgnoreCase(fS7[0]) || chordAnswer.equalsIgnoreCase(fS7[1])
                            || chordAnswer.equalsIgnoreCase(fS7[2]) || chordAnswer.equalsIgnoreCase(fS7[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 31) {

                    if (chordAnswer.equalsIgnoreCase(g7[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 32) {

                    if (chordAnswer.equalsIgnoreCase(gS7[0]) || chordAnswer.equalsIgnoreCase(gS7[1])
                            || chordAnswer.equalsIgnoreCase(gS7[2]) || chordAnswer.equalsIgnoreCase(gS7[3])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 33) {

                    if (chordAnswer.equalsIgnoreCase(a7[0])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 34) {

                    if (chordAnswer.equalsIgnoreCase(aS7[0]) || chordAnswer.equalsIgnoreCase(aS7[1])
                            || chordAnswer.equalsIgnoreCase(aS7[2]) || chordAnswer.equalsIgnoreCase(aS7[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 35) {

                    if (chordAnswer.equalsIgnoreCase(b7[0]) || chordAnswer.equalsIgnoreCase(b7[1])
                            || chordAnswer.equalsIgnoreCase(b7[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                }

                // Corrections diminished

                if (chordNum == 36) {

                    if (chordAnswer.equalsIgnoreCase(c0[0]) || chordAnswer.equalsIgnoreCase(c0[1])
                            || chordAnswer.equalsIgnoreCase(c0[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 37) {

                    if (chordAnswer.equalsIgnoreCase(cS0[0]) || chordAnswer.equalsIgnoreCase(cS0[1])
                            || chordAnswer.equalsIgnoreCase(cS0[2]) || chordAnswer.equalsIgnoreCase(cS0[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 38) {

                    if (chordAnswer.equalsIgnoreCase(d0[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 39) {

                    if (chordAnswer.equalsIgnoreCase(dS0[0]) || chordAnswer.equalsIgnoreCase(dS0[1])
                            || chordAnswer.equalsIgnoreCase(dS0[2]) || chordAnswer.equalsIgnoreCase(dS0[3])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 40) {

                    if (chordAnswer.equalsIgnoreCase(e0[0]) || chordAnswer.equalsIgnoreCase(e0[1])
                            || chordAnswer.equalsIgnoreCase(e0[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 41) {

                    if (chordAnswer.equalsIgnoreCase(f0[0]) || chordAnswer.equalsIgnoreCase(f0[1])
                            || chordAnswer.equalsIgnoreCase(f0[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 42) {

                    if (chordAnswer.equalsIgnoreCase(fS0[0]) || chordAnswer.equalsIgnoreCase(fS0[1])
                            || chordAnswer.equalsIgnoreCase(fS0[2]) || chordAnswer.equalsIgnoreCase(fS0[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 43) {

                    if (chordAnswer.equalsIgnoreCase(g0[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 44) {

                    if (chordAnswer.equalsIgnoreCase(gS0[0]) || chordAnswer.equalsIgnoreCase(gS0[1])
                            || chordAnswer.equalsIgnoreCase(gS0[2]) || chordAnswer.equalsIgnoreCase(gS0[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 45) {

                    if (chordAnswer.equalsIgnoreCase(a0[0])) {

                        correct = true;

                    } else {
                        correct = false;

                    }

                } if (chordNum == 46) {

                    if (chordAnswer.equalsIgnoreCase(aS0[0]) || chordAnswer.equalsIgnoreCase(aS0[1])
                            || chordAnswer.equalsIgnoreCase(aS0[2]) || chordAnswer.equalsIgnoreCase(aS0[3])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 47) {

                    if (chordAnswer.equalsIgnoreCase(b0[0]) || chordAnswer.equalsIgnoreCase(b0[1])
                            || chordAnswer.equalsIgnoreCase(b0[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                }

                // Corrections augmented

                if (chordNum == 48) {

                    if (chordAnswer.equalsIgnoreCase(cA[0]) || chordAnswer.equalsIgnoreCase(cA[1])
                            || chordAnswer.equalsIgnoreCase(cA[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }

                } if (chordNum == 49) {

                    if (chordAnswer.equalsIgnoreCase(cSA[0]) || chordAnswer.equalsIgnoreCase(cSA[1])
                            || chordAnswer.equalsIgnoreCase(cSA[2]) || chordAnswer.equalsIgnoreCase(cSA[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 50) {

                    if (chordAnswer.equalsIgnoreCase(dA[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 51) {

                    if (chordAnswer.equalsIgnoreCase(dSA[0]) || chordAnswer.equalsIgnoreCase(dSA[1])
                            || chordAnswer.equalsIgnoreCase(dSA[2]) || chordAnswer.equalsIgnoreCase(dSA[3])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 52) {

                    if (chordAnswer.equalsIgnoreCase(eA[0]) || chordAnswer.equalsIgnoreCase(eA[1])
                            || chordAnswer.equalsIgnoreCase(eA[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 53) {

                    if (chordAnswer.equalsIgnoreCase(fA[0]) || chordAnswer.equalsIgnoreCase(fA[1])
                            || chordAnswer.equalsIgnoreCase(fA[2])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 54) {

                    if (chordAnswer.equalsIgnoreCase(fSA[0]) || chordAnswer.equalsIgnoreCase(fSA[1])
                            || chordAnswer.equalsIgnoreCase(fSA[2]) || chordAnswer.equalsIgnoreCase(fSA[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 55) {

                    if (chordAnswer.equalsIgnoreCase(gA[0])) {

                        correct = true;

                    } else {

                        correct = false;
                    }

                } if (chordNum == 56) {

                    if (chordAnswer.equalsIgnoreCase(gSA[0]) || chordAnswer.equalsIgnoreCase(gSA[1])
                            || chordAnswer.equalsIgnoreCase(gSA[2]) || chordAnswer.equalsIgnoreCase(gSA[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 57) {

                    if (chordAnswer.equalsIgnoreCase(aA[0])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 58) {

                    if (chordAnswer.equalsIgnoreCase(aSA[0]) || chordAnswer.equalsIgnoreCase(aSA[1])
                            || chordAnswer.equalsIgnoreCase(aSA[2]) || chordAnswer.equalsIgnoreCase(aSA[3])) {

                        correct = true;

                    } else {

                        correct = false;

                    }

                } if (chordNum == 59) {

                    if (chordAnswer.equalsIgnoreCase(bA[0]) || chordAnswer.equalsIgnoreCase(bA[1])
                            || chordAnswer.equalsIgnoreCase(bA[2])) {

                        correct = true;

                    } else {
                        correct = false;
                    }
                }
                ///
                ///END IF STATEMENTS
                ///
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
        //Major Chords

        final MediaPlayer c = MediaPlayer.create(this, R.raw.c);
        final MediaPlayer cs = MediaPlayer.create(this, R.raw.cs);
        final MediaPlayer d = MediaPlayer.create(this, R.raw.d);
        final MediaPlayer ds = MediaPlayer.create(this, R.raw.ds);
        final MediaPlayer e = MediaPlayer.create(this, R.raw.e);
        final MediaPlayer f = MediaPlayer.create(this, R.raw.f);
        final MediaPlayer fs = MediaPlayer.create(this, R.raw.fs);
        final MediaPlayer g = MediaPlayer.create(this, R.raw.g);
        final MediaPlayer gs = MediaPlayer.create(this, R.raw.gs);
        final MediaPlayer a = MediaPlayer.create(this, R.raw.a);
        final MediaPlayer as = MediaPlayer.create(this, R.raw.as);
        final MediaPlayer b = MediaPlayer.create(this, R.raw.b);
        //Minor Chords
        final MediaPlayer cminor = MediaPlayer.create(this, R.raw.cm);
        final MediaPlayer csminor = MediaPlayer.create(this, R.raw.csm);
        final MediaPlayer dminor = MediaPlayer.create(this, R.raw.dm);
        final MediaPlayer dsminor = MediaPlayer.create(this, R.raw.dsm);
        final MediaPlayer eminor = MediaPlayer.create(this, R.raw.em);
        final MediaPlayer fminor = MediaPlayer.create(this, R.raw.fm);
        final MediaPlayer fsminor = MediaPlayer.create(this, R.raw.fsm);


        final MediaPlayer gminor = MediaPlayer.create(this, R.raw.gm);
        final MediaPlayer gsminor = MediaPlayer.create(this, R.raw.gsm);
        final MediaPlayer aminor = MediaPlayer.create(this, R.raw.am);
        final MediaPlayer asminor = MediaPlayer.create(this, R.raw.asm);
        final MediaPlayer bminor = MediaPlayer.create(this, R.raw.bm);

        //Augmented Chords
        final MediaPlayer caugmented = MediaPlayer.create(this, R.raw.ca);
        final MediaPlayer csaugmented = MediaPlayer.create(this, R.raw.csa);
        final MediaPlayer daugmented = MediaPlayer.create(this, R.raw.da);
        final MediaPlayer dsaugmented = MediaPlayer.create(this, R.raw.dsa);
        final MediaPlayer eaugmented = MediaPlayer.create(this, R.raw.ea);
        final MediaPlayer faugmented = MediaPlayer.create(this, R.raw.fa);
        final MediaPlayer fsaugmented = MediaPlayer.create(this, R.raw.fsa);
        final MediaPlayer gaugmented = MediaPlayer.create(this, R.raw.ga);
        final MediaPlayer gsaugmented = MediaPlayer.create(this, R.raw.gsa);
        final MediaPlayer aaugmented = MediaPlayer.create(this, R.raw.aa);
        final MediaPlayer asaugmented = MediaPlayer.create(this, R.raw.asa);
        final MediaPlayer baugmented = MediaPlayer.create(this, R.raw.ba);

        //Diminished Chords
        final MediaPlayer cdiminished = MediaPlayer.create(this, R.raw.co);
        final MediaPlayer csdiminished = MediaPlayer.create(this, R.raw.cso);


        final MediaPlayer ddiminished = MediaPlayer.create(this, R.raw.doo);
        final MediaPlayer dsdiminished = MediaPlayer.create(this, R.raw.dso);
        final MediaPlayer ediminished = MediaPlayer.create(this, R.raw.eo);
        final MediaPlayer fdiminished = MediaPlayer.create(this, R.raw.fo);
        final MediaPlayer fsdiminished = MediaPlayer.create(this, R.raw.fso);
        final MediaPlayer gdiminished = MediaPlayer.create(this, R.raw.go);
        final MediaPlayer gsdiminished = MediaPlayer.create(this, R.raw.gso);
        final MediaPlayer adiminished = MediaPlayer.create(this, R.raw.ao);
        final MediaPlayer asdiminished = MediaPlayer.create(this, R.raw.aso);
        final MediaPlayer bdiminished = MediaPlayer.create(this, R.raw.bo);

        //Dominant Chords
        final MediaPlayer cdominant = MediaPlayer.create(this, R.raw.c7);
        final MediaPlayer csdominant = MediaPlayer.create(this, R.raw.cs7);
        final MediaPlayer ddominant = MediaPlayer.create(this, R.raw.d7);
        final MediaPlayer dsdominant = MediaPlayer.create(this, R.raw.ds7);
        final MediaPlayer edominant = MediaPlayer.create(this, R.raw.e7);
        final MediaPlayer fdominant = MediaPlayer.create(this, R.raw.f7);
        final MediaPlayer fsdominant = MediaPlayer.create(this, R.raw.fs7);
        final MediaPlayer gdominant = MediaPlayer.create(this, R.raw.g7);
        final MediaPlayer gsdominant = MediaPlayer.create(this, R.raw.gs7);
        final MediaPlayer adominant = MediaPlayer.create(this, R.raw.a7);
        final MediaPlayer asdominant = MediaPlayer.create(this, R.raw.as7);
        final MediaPlayer bdominant = MediaPlayer.create(this, R.raw.b7);

        playAgn = (Button) findViewById(R.id.sound_btn);
        playAgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chordNum == 0) {
                    c.start();
                } else if (chordNum == 1) {
                    cs.start();
                } else if (chordNum == 2) {
                    d.start();
                } else if (chordNum == 3) {
                    ds.start();
                } else if (chordNum == 4) {
                    e.start();
                } else if (chordNum == 5) {
                    f.start();
                } else if (chordNum == 6) {
                    fs.start();
                } else if (chordNum == 7) {
                    g.start();
                } else if (chordNum == 8) {
                    gs.start();
                } else if (chordNum == 9) {
                    a.start();
                } else if (chordNum == 10) {
                    as.start();
                } else if (chordNum == 11) {
                    b.start();
                } else if (chordNum == 12) {
                    cminor.start();
                } else if (chordNum == 13) {
                    csminor.start();
                } else if (chordNum == 14) {
                    dminor.start();
                } else if (chordNum == 15) {
                    dsminor.start();
                } else if (chordNum == 16) {
                    eminor.start();
                } else if (chordNum == 17) {
                    fminor.start();
                } else if (chordNum == 18) {
                    fsminor.start();
                } else if (chordNum == 19) {
                    gminor.start();
                } else if (chordNum == 20) {
                    gsminor.start();
                } else if (chordNum == 21) {
                    aaugmented.start();
                } else if (chordNum == 22) {
                    asaugmented.start();
                } else if (chordNum == 23) {
                    baugmented.start();
                } else if (chordNum == 24) {
                    caugmented.start();
                } else if (chordNum == 25) {
                    csaugmented.start();
                } else if (chordNum == 26) {
                    daugmented.start();
                } else if (chordNum == 27) {
                    dsaugmented.start();
                } else if (chordNum == 28) {
                    eaugmented.start();
                } else if (chordNum == 29) {
                    faugmented.start();
                } else if (chordNum == 30) {
                    fsaugmented.start();
                } else if (chordNum == 31) {
                    gaugmented.start();
                } else if (chordNum == 32) {
                    gsaugmented.start();
                } else if (chordNum == 33) {
                    aaugmented.start();
                } else if (chordNum == 34) {
                    asaugmented.start();
                } else if (chordNum == 35) {
                    baugmented.start();
                } else if (chordNum == 36) {
                    cdiminished.start();
                } else if (chordNum == 37) {
                    csdiminished.start();
                } else if (chordNum == 38) {
                    ddiminished.start();
                } else if (chordNum == 39) {
                    dsdiminished.start();
                } else if (chordNum == 40) {
                    ediminished.start();
                } else if (chordNum == 41) {
                    fdiminished.start();
                } else if (chordNum == 42) {
                    fsdiminished.start();
                } else if (chordNum == 43) {
                    gdiminished.start();
                } else if (chordNum == 44) {
                    gsdiminished.start();
                } else if (chordNum == 45) {
                    adiminished.start();
                } else if (chordNum == 46) {
                    asdiminished.start();
                } else if (chordNum == 47) {
                    bdiminished.start();
                } else if (chordNum == 48) {
                    cdominant.start();
                } else if (chordNum == 49) {
                    csdominant.start();
                } else if (chordNum == 50) {
                    ddominant.start();
                } else if (chordNum == 51) {
                    dsdominant.start();
                } else if (chordNum == 52) {
                    edominant.start();
                } else if (chordNum == 53) {
                    fdominant.start();
                } else if (chordNum == 54) {
                    fsdominant.start();
                } else if (chordNum == 55) {
                    gdominant.start();
                } else if (chordNum == 56) {
                    gsdominant.start();
                } else if (chordNum == 57) {
                    adominant.start();
                } else if (chordNum == 58) {
                    asdominant.start();
                } else if (chordNum == 59) {
                    bdominant.start();
                }
            }
        });
    }
}