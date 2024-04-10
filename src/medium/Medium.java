package medium;

import java.util.ArrayList;
import java.util.Stack;

public class Medium {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ");
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i != 0) {
                result.append(words[i]);
                result.append(" ");
            } else {
                result.append(words[i]);
            }
        }

        return result.toString().strip();
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] sufixes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixes[i] = 1;
            sufixes[i] = 1;
        }

        int prefixToMultiply = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixToMultiply *= nums[i - 1];
            prefixes[i] *= prefixToMultiply;
        }

        int sufixToMultiply = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sufixToMultiply *= nums[i + 1];
            sufixes[i] = sufixToMultiply;
        }

        for (int i = 0; i < nums.length; i++) {
            prefixes[i] *= sufixes[i];
        }
        return prefixes;
    }

       public String removeStars(String s) {
        int charsToRemove = 0;
        Stack<Character> sChars = new Stack<>();
        for (Character letter: s.toCharArray()) {
            sChars.push(letter);
        }

        ArrayList<Character> result = new ArrayList<>();

        while (!sChars.empty()) {
            if (sChars.peek() == '*') {
                charsToRemove++;
                sChars.pop();
            } else if(sChars.peek() != '*' && charsToRemove == 0) {
                result.add(sChars.peek());
                sChars.pop();
            } else {
                sChars.pop();
                charsToRemove--;
            }
        }
        StringBuilder resultToReturn = new StringBuilder();
        for(char letter: result.reversed()) {
            resultToReturn.append(letter);
        }
        return resultToReturn.toString();
    }
}
