package easy;

import java.util.HashMap;
import java.util.Map;

public class Easy {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];

        // search for the solution
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }

        // it will never get here, it is assumed that there is one solution
        return solution;
    }

    public boolean isPalindrome(int x) {
        // convert the number to a string
        String number = Integer.toString(x);

        // use two pointers to see if it is a palindrome
        int p1 = 0;
        int p2 = number.length() - 1;
        while (p1 < p2) {
            if (number.charAt(p1) != number.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (Character letter: s.toCharArray()) {
            int count = letters.getOrDefault(letter, 0);
            letters.put(letter, count + 1);
        }

        for (Character letter: t.toCharArray()) {
            int count = letters.getOrDefault(letter, 0);
            if (count == 0) {
                return false;
            } else {
                letters.put(letter, count - 1);
            }
        }

        for (int value: letters.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public int romanToInt(String s) {
        int result = 0;
        int lettersChecked = 0;
        HashMap<Character, Integer> romanNumbers = new HashMap<>();

        // add the letters in the hash map
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            int romanNumber1 = romanNumbers.get(s.charAt(i));
            int romanNumber2 = romanNumbers.get(s.charAt(i + 1));
            if (romanNumber1 >= romanNumber2) {
                lettersChecked++;
                result += romanNumber1;
            } else {
                lettersChecked += 2;
                i++;
                result += romanNumber2 - romanNumber1;
            }
        }

        if (lettersChecked != s.length()) {
            result += romanNumbers.get(s.charAt(s.length() - 1));
        }
        return result;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int targetPosition = -1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                targetPosition = middle;
                return targetPosition;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return targetPosition;
    }
}
