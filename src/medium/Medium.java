package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> word1Chars = new HashMap<>();
        HashMap<Character, Integer> word2Chars = new HashMap<>();

        for (char letter: word1.toCharArray()) {
            if (!word1Chars.containsKey(letter)) {
                word1Chars.put(letter, 1);
            } else {
                word1Chars.replace(letter, word1Chars.get(letter) + 1);
            }
        }

        for (char letter: word2.toCharArray()) {
            if (!word2Chars.containsKey(letter)) {
                word2Chars.put(letter, 1);
            } else {
                word2Chars.replace(letter, word2Chars.get(letter) + 1);
            }
        }

        if (word1.length() != word2.length()) {
            return false;
        }

        HashSet<Character> checkedLetters  = new HashSet<>();

        for (char key: word1Chars.keySet()) {
            if (!word2Chars.containsKey(key)) {
                return false;
            } else if (word1Chars.get(key) != word2Chars.get(key)) {
                for (char key1: word1Chars.keySet()) {
                    if (word1Chars.get(key) != word2Chars.get(key)
                            && word1Chars.get(key1) == word2Chars.get(key)
                            && !checkedLetters.contains(key1)) {
                        int aux = word1Chars.get(key1);
                        word1Chars.replace(key, aux);

                    }
                }
            } else {
                checkedLetters.add(key);
            }
        }
        return false;
    }

    public int uniquePaths(int m, int n) {
        int[][] numberOfPaths= new int[m][n];

        for (int i = 0; i < n; i++) {
            numberOfPaths[0][i] = 1;
        }

        for (int i = 0; i < m ; i++) {
            numberOfPaths[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                numberOfPaths[i][j] = numberOfPaths[i - 1][j] + numberOfPaths[i][j - 1];
            }
        }

        return numberOfPaths[m - 1][n - 1];
    }

}
