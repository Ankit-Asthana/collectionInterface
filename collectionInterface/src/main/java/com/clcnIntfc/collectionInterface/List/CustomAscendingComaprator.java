package com.clcnIntfc.collectionInterface.List;

import java.util.Comparator;

public class CustomAscendingComaprator implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();  // s1 -> "Deck", s2 -> "Dog" {Dog will comes first than Deck}
    }
}
