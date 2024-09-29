package com.striim.ec;

public class BracketCheck {
    public static void main(String[] args) {
        String str = ")(((()()()))";
        if (areBracketsBalanced(str))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
    public static boolean areBracketsBalanced(String s)
    {
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack[++i] = ch;
            else {
                if (i >= 0 && ((stack[i] == '(' && ch == ')')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
}
