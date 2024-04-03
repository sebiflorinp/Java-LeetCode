package easy;

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
}
