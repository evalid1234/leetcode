package org.resume.slidingWindow;

//Given a string s, find the length of the longest
//substring
//without repeating characters// .

import java.util.HashSet;
import java.util.Set;

//two pointer/ sliding window approach


public class LongestSubstringNoRepeatChar {


    public LongestSubstringNoRepeatChar (String s) {
        int res = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring with no repearing chars is: " + res);
    }

    private boolean characterIsInWindow(Character element, HashSet window) {
        return window.contains(element);
    }

    private void addCharacterToWindow(Character element, HashSet window){
        window.add(element);
    }

    private int returnNewLeftUpdateWindow(HashSet window, String s, int l, int r) {

        char target= s.charAt(r);
        while(l < r) {
            if (s.charAt(l) == target){
                break;
            }
            window.remove(s.charAt(l));
            l++;

        }
        return l+1;
    }


    private int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int longestSubString = 0;

        for (int left =0, right=0 ; right < s.length(); ++right) {
            Character character = s.charAt(right);
            if (characterIsInWindow(character, set)){

                left=returnNewLeftUpdateWindow(set, s, left, right);
                //we know the dulicate is the at the right pointer.
            }else{
                //character not in the window.
                addCharacterToWindow(character, set);
                longestSubString = Math.max(set.size(), longestSubString);
            }
        }
        return longestSubString;
    }

}
