package com.interviewbit.amazone.stacksAndQueues;

import java.util.Stack;

public class BalancedParenthesis {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public int solve(String A) {
        Stack<Character> characterStack = new Stack<>();
        char[] chars = A.toCharArray();
        for (char ch : chars) {
            if (isLeftBracket(ch))
                characterStack.push(ch);

            if (isRightBracket(ch)) {
                if (characterStack.isEmpty())
                    return 0;

                char topBracket = characterStack.pop();

                if (!bracketMatches(ch, topBracket))
                    return 0;
            }
        }
        if (characterStack.isEmpty())
            return 1;
        return 0;
    }

    private boolean isLeftBracket(char bracket) {
        return LEFT_BRACKET == bracket;
    }

    private boolean isRightBracket(char bracket) {
        return RIGHT_BRACKET == bracket;
    }

    private boolean bracketMatches(char right, char left) {
        return (LEFT_BRACKET == left) && (RIGHT_BRACKET == right);
    }

    public static void main(String[] args) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
//        System.out.println(balancedParenthesis.solve("(()())"));
        System.out.println(balancedParenthesis.solve("(()"));
    }
}
