package com.ebookfrenzy.fastermind;

/**
 * Class used pulled from: https://sumitpal.wordpress.com/2011/11/15/levenshtein-distance-calculation-using-dynamic-programming-and-forkjoin-framework/
 * and all credit goes to Sumitpal
 *
 * Only small edits have been made for our purpose.
 */
import java.util.*;

public class LevenshteinDistanceUsingDynamicProgramming
{

    public LevenshteinDistanceUsingDynamicProgramming(){
    }

    public int compute(String str1, String str2)
    {
//	System.out.println(str1 + ", " + str2);
        if ( str1.length() == 0 )
            return str2.length();
        if ( str2.length() == 0 )
            return str1.length();

        String newStr1 = str1.substring(1);
        String newStr2 = str2.substring(1);
        if ( str1.charAt(0) == str2.charAt(0) )
            return compute(newStr1, newStr2);
        else
        {
// get the String after the 1st Char of str1 and str2
            int one = 1 + compute(newStr1, newStr2);
            int two = 1 + compute(newStr1, str2);
            int three = 1 + compute(str1, newStr2);
            return Math.min(one, Math.min(two, three));
        }
    }
}