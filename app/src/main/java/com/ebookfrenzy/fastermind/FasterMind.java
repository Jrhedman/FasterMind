package com.ebookfrenzy.fastermind;
/*
    @Author Jaoob Hedman, Jacob.Hedman1@gmail.com
    @Date 10/18/2016
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

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

        private PriorityQueue<Character> firstChar = new PriorityQueue<Character>(10, new Comparator<Character>() {
            public int compare(Character x, Character y) {
                if (x < y) return 1;
                if (x > y) return -1;
                return 0;
            }
        });
        private PriorityQueue<Character> secondChar = new PriorityQueue<Character>(10, new Comparator<Character>() {
            public int compare(Character x, Character y) {
                if (x < y) return 1;
                if (x > y) return -1;
                return 0;
            }
        });
        private PriorityQueue<Character> thirdChar = new PriorityQueue<Character>(10, new Comparator<Character>() {
            public int compare(Character x, Character y) {
                if (x < y) return 1;
                if (x > y) return -1;
                return 0;
            }
        });
        private PriorityQueue<Character> fourthChar = new PriorityQueue<Character>(10, new Comparator<Character>() {
            public int compare(Character x, Character y) {
                if (x < y) return 1;
                if (x > y) return -1;
                return 0;
            }
        });

        private HashMap<Character,Integer> firstCharHash = new HashMap<Character,Integer>();
        private HashMap<Character,Integer> secondCharHash = new HashMap<Character,Integer>();
        private HashMap<Character,Integer> thirdCharHash = new HashMap<Character,Integer>();
        private HashMap<Character,Integer> fourthCharHash = new HashMap<Character,Integer>();


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

        firstChar.
    }
/*-------------------------------Button Calls-----------------------------------------------------*/
    /*
        resetGame - called when the RESET button gets pushed.

        this button:
            - resets the letterBeingChecked TextView to "____"
            - resets the numOfGuesses TextView to "0"
            - generates a new random word from the list
            - displays the new word in targetWord TextView
            - requests the computer to create an initial guess of what the word is
            - displays the guessed word in the computerWord TextView
     */
    private void resetGame(View view){

    }

    /*
        rightLrightPosition - called when the RIGHT LETTER RIGHT POSITION button gets pushed.

        this button:
            -
     */
    private void rightLrightPosition(View view){

    }

    /*
        rightLwrongPosition - called when the RIGHT LETTER WRONG POSITION button gets pushed.

        this button:
            -
     */
    private void rightLwrongPosition(View view){

    }

    /*
        wrongLwrongPosition - called when the WRONG LETTER WRONG POSITION button gets pushed.

         this button:
            -
     */
    private void wrongLwrongPosition(View view){

    }
}