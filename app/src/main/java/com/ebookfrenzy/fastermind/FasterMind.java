package com.ebookfrenzy.fastermind;
/*
    @Author Jaoob Hedman, Jacob.Hedman1@gmail.com
    @Date 10/18/2016
 */
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class FasterMind extends AppCompatActivity {
    //Fields
        private final int WORD_LENGTH = 4;
        private int guessCounter = 0;
        private String goalWord;
        private String guessWord;
        private int letterCounter = 0;
        private boolean[] charFlag = {false, false, false, false};

        private FasterMindDictionary dictionary;
        private TextView targetWord;
        private TextView computerWord;
        private TextView numOfGuesses;
        private TextView letterBeingChecked;
        private TextView decWinner;

        private Button rightLrightPosBtn;
        private Button rightLwrongPosBtn;
        private Button wrongLwrongPosBtn;
        private Button resetBtn;


        private PriorityQueue<letterWeight> firstChar = new PriorityQueue<letterWeight>(26, new Comparator<letterWeight>() {
            @Override
            public int compare(letterWeight o1, letterWeight o2) {
                return o1.compareTo(o2);
            }
        });
        private PriorityQueue<letterWeight> secondChar = new PriorityQueue<letterWeight>(26, new Comparator<letterWeight>() {
            @Override
            public int compare(letterWeight o1, letterWeight o2) {
                return o1.compareTo(o2);
            }
        });
        private PriorityQueue<letterWeight> thirdChar = new PriorityQueue<letterWeight>(26, new Comparator<letterWeight>() {
            @Override
            public int compare(letterWeight o1, letterWeight o2) {
                return o1.compareTo(o2);
            }
        });
        private PriorityQueue<letterWeight> fourthChar = new PriorityQueue<letterWeight>(26, new Comparator<letterWeight>() {
            @Override
            public int compare(letterWeight o1, letterWeight o2) {
                return o1.compareTo(o2);
            }
        });




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faster_mind);
        targetWord = (TextView) findViewById(R.id.targetWord);
        computerWord = (TextView) findViewById(R.id.computerWord);
        numOfGuesses = (TextView) findViewById(R.id.numOfGuesses);
        letterBeingChecked = (TextView) findViewById(R.id.letterBeingChecked);
        decWinner = (TextView) findViewById(R.id.decWinner);

        rightLrightPosBtn = (Button) findViewById(R.id.rightLrightPosition);
        rightLwrongPosBtn = (Button) findViewById(R.id.rightLwrongPosition);
        wrongLwrongPosBtn = (Button) findViewById(R.id.wrongLwrongPosition);
        resetBtn = (Button)findViewById(R.id.reset);

        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("words.txt");
            dictionary = new SimpleDictionary(inputStream);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }

        resetBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                resetGame();
            }
        });

        rightLrightPosBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rightLrightPosition();
            }
        });

        wrongLwrongPosBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                wrongLwrongPosition();
            }
        });




        resetGame();



    }
/*-------------------------------Button Calls-----------------------------------------------------*/
    /*
        resetGame - called when the RESET button gets pushed.

        this button:
          /  - resets the letterBeingChecked TextView to "____"
          /  - resets the numOfGuesses TextView to "0"
          /  - generates a new random word from the list
          / - displays the new word in targetWord TextView
            - requests the computer to create an initial guess of what the word is
            - displays the guessed word in the computerWord TextView
     */




    private void resetGame(){
        //Generates Priority Queues
            firstChar.addAll(dictionary.getFirstHashValues());
            secondChar.addAll(dictionary.getSecondHashValues());
            thirdChar.addAll(dictionary.getThirdHashValues());
            fourthChar.addAll(dictionary.getFourthHashValues());

            letterCounter = 0;
            letterBeingChecked.setText("____");
            guessCounter = 0;
            numOfGuesses.setText(Integer.toString(guessCounter));
            goalWord = dictionary.getRandomWord();
            targetWord.setText(goalWord);
            decWinner.setText("....");
            gameTurn();

         //   letterBeingChecked.setText(guessWord.charAt(letterCounter));

    }

    private void gameTurn(){

        guessWord = computerGuess();
        computerWord.setText(guessWord);
        numOfGuesses.setText(Integer.toString(guessCounter));
    }


    public void validateWord(){
        letterCounter = 0;
        if(guessWord.compareTo(goalWord) == 0){
            decWinner.setText("Computer Won");
        }
            gameTurn();
    }



    /*
        rightLrightPosition - called when the RIGHT LETTER RIGHT POSITION button gets pushed.

        this button:
            -
     */
    private void rightLrightPosition(){
        if(letterCounter <= 3){
            charFlag[letterCounter] = true;
            letterCounter++;
        }else{
            validateWord();
        }

    }

    /*
        rightLwrongPosition - called when the RIGHT LETTER WRONG POSITION button gets pushed.

        this button:
            -

    private void rightLwrongPosition(View view){

    }*/

    /*
        wrongLwrongPosition - called when the WRONG LETTER WRONG POSITION button gets pushed.

         this button:
            -
     */
    private void wrongLwrongPosition(){
     if(letterCounter <= 3) {
         charFlag[letterCounter] = false;
         letterCounter++;
     }else{
        validateWord();
     }
    }


    private String computerGuess(){
        StringBuffer sb = new StringBuffer();
        if(!charFlag[0]) {
            sb.append(firstChar.poll());
        }else
            sb.append(guessWord.charAt(0));
        if(!charFlag[1]) {
            sb.append(secondChar.poll());
        }else
            sb.append(guessWord.charAt(1));
        if(!charFlag[2]) {
            sb.append(thirdChar.poll());
        }else
            sb.append(guessWord.charAt(2));
        if(!charFlag[3]) {
            sb.append(fourthChar.poll());
        }else
            sb.append(guessWord.charAt(3));


        guessCounter++;

        return sb.toString();
    }
}