package com.ebookfrenzy.fastermind;

/**
 * Created by Joshua on 10/22/2016.
 *
 * Wrapper Class that holds a character and its weight
 */

public class letterWeight {
    private Character letter;
    private int weight;

    //constructor
        public letterWeight(Character newLetter){
            this.letter = newLetter;
            setWeight(1);
        }
    //getletter
        public Character getLetter(){
            return letter;
        }
    //getweight
        public int getWeight(){
            return weight;
        }
    //setweight
        public void setWeight(int newWeight){
            this.weight = newWeight;
        }
    //addWeight
        public void addWeight(int addedWeight){
            this.weight = getWeight()+ addedWeight;
        }
    //toString
        public String toString(){
            return letter.toString();
        }
    //compareTo
        public int compareTo(letterWeight other){
            if(this.getWeight() < other.getWeight())
                return 1;
            else if(this.getWeight() > other.getWeight())
                return -1;
            else
                return 0;
        }
}
