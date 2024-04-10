package easy;

import java.lang.reflect.Array;
import java.util.*;

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

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int stone: stones) {
            stoneQueue.add(stone);
        }

        while (stoneQueue.size() > 1) {
            int stone1 = stoneQueue.remove();
            int stone2 = stoneQueue.remove();
            if (stone1 - stone2 != 0) {
                stoneQueue.add(stone1 - stone2);
            }
        }

        if (stoneQueue.isEmpty()) {
            return 0;
        } else {
            return stoneQueue.remove();
        }
    }

    public String mergeAlternately(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int index1=0;
        int index2=0;
        String result = "";
        while (index1 < word1.length() && index2 < word2.length()) {
            if (index1 <= index2) {
                result = result.concat(Character.toString(word1Chars[index1]));
                index1 += 1;
            } else {
                result = result.concat(Character.toString(word2Chars[index2]));
                index2 += 1;
            }
        }

        if (index1 < word1.length()) {
            for (; index1 < word1.length(); index1++) {
                result = result.concat(Character.toString(word1Chars[index1]));
            }
        }

        if (index2 < word2.length()) {
            for (; index2 < word2.length(); index2++) {
                result = result.concat(Character.toString(word2Chars[index2]));
            }
        }

        return result;
    }

    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        while (l1 != l2) {
            if (l1 < l2) {
                l2 -= l1;
            } else {
                l1 -= l2;
            }
        }
        String gdc = str1.substring(0 , l1);
        int start = 0;
        while(start < Math.max(str1.length(), str2.length())) {
            if (start + l1 <= str1.length()) {
                if (!str1.substring(start, start + l1).equals(gdc)) {
                    return "";
                }
            }

            if (start + l1 <= str2.length()) {
                if (!str2.substring(start, start + l1).equals(gdc)) {
                    return "";
                }
            }
            start += l1;
        }
        return gdc;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find the max amount of candies
        int maxCandies = 0;
        for (int candy: candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        // create the result
        List<Boolean> result = new ArrayList<>();
        for (int candy: candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
              return n <= 1;
            } else {
                return n == 0;
            }
        }
        int placedFlowers = 0;
        for (int i = 0; i < flowerbed.length ; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    placedFlowers++;
                    flowerbed[i] = 1;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    placedFlowers++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i-1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                placedFlowers++;
                flowerbed[i] = 1;
            }
        }

        return placedFlowers >= n;
    }

    public String reverseVowels(String s) {
        char[] characters = s.toCharArray();
        int p1 = 0;
        int p2 = characters.length - 1;
        while (p1 < p2) {
            if ("AEIOUaeiou".indexOf(characters[p1]) != - 1 && "AEIOUaeiou".indexOf(characters[p2]) != - 1) {
                char aux = characters[p1];
                characters[p1] = characters[p2];
                characters[p2] = aux;
                p1++;
                p2--;
            }

            if ("AEIOUaeoiu".indexOf(characters[p1]) == -1) {
                p1++;
            }

            if ("AEIOUaeiou".indexOf(characters[p2]) == -1) {
                p2--;
            }
        }
       return new String(characters);
    }

    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] == 0 && nums[p2] != 0) {
                int aux = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = aux;
                p1++;
            }
            p2++;
            if (nums[p1] != 0) {
                p1++;
            }
        }
    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int p1 = 0;
        int p2 = 0;
        int foundLetters = 0;
        if (s.isEmpty()) {
            return true;
        }

        while (p2 < t.length()) {
            if (sChars[p1] == tChars[p2]) {
                p1++;
                foundLetters++;
            }
            p2++;
            if (p1 == s.length()) {
                return true;
            }
        }

        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+= nums[i];
        }
        int maxSum = sum;
        for(int i = 1; i < nums.length - k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            if (sum >= maxSum) {
                maxSum = sum;
            }
        }
        return (double) maxSum / k;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
        for (int number: nums1) {
            values.put(number, 1);
        }

        for (int number: nums2) {
            if (values.containsKey(number)) {
                values.put(number, 3);
            } else {
                values.put(number, 2);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int key: values.keySet()) {
            if (values.get(key) == 1) {
                l1.add(key);
            } else if (values.get(key) == 2) {
                l2.add(key);
            }
        }
        result.add(l1);
        result.add(l2);
        return result;
    }
}


