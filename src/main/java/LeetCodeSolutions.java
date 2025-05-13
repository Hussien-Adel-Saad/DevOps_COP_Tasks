import java.util.HashMap;
import java.util.Map;

public class LeetCodeSolutions {

    // Problem 1: Palindrome Number
    public static boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even and odd lengths:
        return x == reversedHalf || x == reversedHalf / 10;
    }


    // Problem 2: Roman to Integer
    public static int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));

            // Step 3: Apply subtractive logic
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }
        return total;
    }

    // Problem 3: Climbing stairs
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int previous = 1, current = 1;
        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    // Problem 4: Length of last word
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }


    public static void main(String[] args) {

        //Test Palindrome Number
        System.out.println(isPalindrome(121));

        // Test Roman to Integer
        String romanNum = "MCXCI";
        System.out.println("Integer number for this roman representation (" + romanNum + ") is : " + romanToInt(romanNum));


        // Test Climbing stairs
        int target = 8;
        System.out.println("Number of distinct ways to climb to floor no." + target + " is : " + climbStairs(target));


        //Test Length of last word
        String phrase = "DevOps is fun ";
        System.out.println("Length of last word in string is : " + lengthOfLastWord(phrase));

    }
}
