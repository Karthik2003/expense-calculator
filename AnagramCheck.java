package com.striim.ec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "Care";
        System.out.println("----------"+str1.charAt(str1.length() - 1 - 0));

        if(checkAnagram(str1.toLowerCase(), str2.toLowerCase())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean checkAnagram(String str1, String str2) {
        boolean check = false;
        if(str1.length() != str2.length()) {
            return check;
        } else {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            return Arrays.equals(ch1, ch2);
        }
    }
}
