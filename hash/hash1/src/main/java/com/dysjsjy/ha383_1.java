package com.dysjsjy;

public class ha383_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countWords = new int[26];

        for (char c : ransomNote.toCharArray()) {
            countWords[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            countWords[c - 'a']--;
        }

        for (int word : countWords) {
            if (word > 0) return false;
        }

        return true;
    }
}
