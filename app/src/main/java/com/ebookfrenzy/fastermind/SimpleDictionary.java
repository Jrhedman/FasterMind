/*
@authors: Jacob Hedman
@authors: Josh Blair

 */
package com.ebookfrenzy.fastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import android.util.Log;


public class SimpleDictionary implements FasterMindDictionary {
    private ArrayList<String> words;

    private HashMap<Character,letterWeight> firstCharHash = new HashMap<Character,letterWeight>(26);
    private HashMap<Character,letterWeight> secondCharHash = new HashMap<Character,letterWeight>(26);
    private HashMap<Character,letterWeight> thirdCharHash = new HashMap<Character,letterWeight>(26);
    private HashMap<Character,letterWeight> fourthCharHash = new HashMap<Character,letterWeight>(26);


    public SimpleDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        words = new ArrayList<>();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() == WORD_LENGTH) {
                words.add(line.trim());

                if(firstCharHash.get(word.charAt(0)) == null)
                    firstCharHash.put(word.charAt(0), new letterWeight(word.charAt(0)));
                else
                    firstCharHash.get(word.charAt(0)).addWeight(1);

                if(secondCharHash.get(word.charAt(1)) == null)
                    secondCharHash.put(word.charAt(1), new letterWeight(word.charAt(1)));
                else
                    secondCharHash.get(word.charAt(1)).addWeight(1);

                if(thirdCharHash.get(word.charAt(2)) == null)
                    thirdCharHash.put(word.charAt(2), new letterWeight(word.charAt(2)));
                else
                    thirdCharHash.get(word.charAt(2)).addWeight(1);

                if(fourthCharHash.get(word.charAt(3)) == null)
                    fourthCharHash.put(word.charAt(3), new letterWeight(word.charAt(3)));
                else
                    fourthCharHash.get(word.charAt(3)).addWeight(1);

            }
        }
    }
    
    public Collection<letterWeight> getFirstHashValues(){
        return firstCharHash.values();
    }

    public Collection<letterWeight> getSecondHashValues(){
        return secondCharHash.values();
    }

    public Collection<letterWeight> getThirdHashValues(){
        return thirdCharHash.values();
    }

    public Collection<letterWeight> getFourthHashValues(){
        return fourthCharHash.values();
    }


    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        Random random = new Random();
        int num = random.nextInt(words.size());

        if(prefix.isEmpty()){
            return words.get(num);
        }
        else{
            int index = binarySearchWord(prefix, 0, words.size());

            if(index == -1)
                return null;
            else{
                Log.e("wordfromprefix", words.get(index));
                return words.get(index);
        }}

    }

    public int binarySearchWord(String prefix, int lowerBound, int upperBound){
        if(upperBound <= lowerBound)
            return -1;
        int mid = (lowerBound + upperBound) /2;
        if(words.get(mid).startsWith(prefix) && words.get(mid) != prefix)
            return mid;
        if(words.get(mid).compareTo(prefix) > 0) {
            Log.e("Comes Before!","Comes Before!");
            return binarySearchWord(prefix, lowerBound, mid - 1);

        }
        else if(words.get(mid).compareTo(prefix) < 0) {
            Log.e("Comes After!", "Comes After!");
            return binarySearchWord(prefix, mid + 1, upperBound);
        }
        else{
            Log.e("Using Mid", "Using Mid");
            return mid;
    }}

    @Override
    public String getGoodWordStartingWith(String prefix) {
        String selected = null;
        return selected;
    }
}
