package com.ebookfrenzy.fastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FasterMind extends AppCompatActivity {
    //Fields
        private final int WORD_LENGTH = 4;

        private TextView targetWord;
        private TextView computerWord;
        private TextView numOfGuesses;
        private TextView letterBeingChecked;

        private Button rightLrightPosBtn;
        private Button rightLwrongPosBtn;
        private Button wrongLwrongPosBtn;
        private Button resetBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faster_mind);

        targetWord = (TextView) findViewById(R.id.targetWord);
        computerWord = (TextView) findViewById(R.id.computerWord);
        numOfGuesses = (TextView) findViewById(R.id.numOfGuesses);
        letterBeingChecked = (TextView) findViewById(R.id.letterBeingChecked);

        rightLrightPosBtn = (Button) findViewById(R.id.rightLrightPosition);
        rightLwrongPosBtn = (Button) findViewById(R.id.rightLwrongPosition);
        wrongLwrongPosBtn = (Button) findViewById(R.id.wrongLwrongPosition);
        resetBtn = (Button) findViewById(R.id.reset);
    }


}
