package com.ebookfrenzy.fastermind;

import java.util.Collection;

/**
 * Created by apicard on 9/16/15.
 */

public interface FasterMindDictionary {
    public final static int WORD_LENGTH = 4;
    boolean isWord(String word);
    String getAnyWordStartingWith(String prefix);
    String getGoodWordStartingWith(String prefix);
    Collection<letterWeight> getFirstHashValues();
    Collection<letterWeight> getSecondHashValues();
    Collection<letterWeight> getThirdHashValues();
    Collection<letterWeight> getFourthHashValues();
    String getRandomWord();
}
