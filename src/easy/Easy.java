package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public boolean isPalindrome(String s) {
        // create new string and remove all elements that are not letters
        String formattedString = "";
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if ('a' <= character && character <= 'z' || 'A' <= character && character <= 'Z' || '0' <= character && character <= '9') {
                Character characterToAdd = Character.toLowerCase(character);
                formattedString = formattedString.concat(characterToAdd.toString());
            }
        }

        // check if the number is a palindrome
        int p1 = 0;
        int p2 = formattedString.length() - 1;
        while (p1 <= p2) {
            if (formattedString.charAt(p1) != formattedString.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public int[] twoSumOrdered(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        while (numbers[p1] + numbers[p2] != target) {
            if (numbers[p1] + numbers[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        int[] solution = new int[2];
        solution[0] = p1 + 1;
        solution[1] = p2 + 1;
        return solution;
    }

    public boolean isValid(String s) {
        Stack<Character> paranthesisStack = new Stack<>();
        for (Character paranthesis: s.toCharArray()) {
            if (paranthesis == '(' || paranthesis == '[' || paranthesis == '{') {
                paranthesisStack.push(paranthesis);
            } else {
                if (paranthesisStack.empty()) {
                    return false;
                }
                boolean comparisonResult = switch (paranthesisStack.peek()) {
                    case '(' -> paranthesis == ')';
                    case '[' -> paranthesis == ']';
                    default -> paranthesis == '}';
                };
                if (!comparisonResult) {
                    return false;
                }
                paranthesisStack.pop();
            }
        }

        return paranthesisStack.empty();
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
