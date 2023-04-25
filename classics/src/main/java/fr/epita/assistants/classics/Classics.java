package fr.epita.assistants.classics;

import java.util.Locale;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
            return -1;

        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n < 0)
            return -1;

        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        long t0 = 0;
        long t1 = 1;
        long t2 = 1;
        long tn = t0 + t1 + t2;

        for (int i = 2; i < n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {

        String tmp = word.replace(" ", "");
        int length = tmp.length();
        for (int i = 0; i < length; i++)
        {
            if (tmp.toLowerCase().charAt(i) != tmp.toLowerCase().charAt(length - i - 1))
                return false;
        }

        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++)
        {
            int j = i;
            while (j > 0 && array[j - 1] > array[j])
            {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
                j -= 1;
            }
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        var combined = new StringBuilder("");

        int i = 0;
        int j = 0;
        int k = 0;
        int lengthA = a.length();
        int lengthB = b.length();

        while (i < lengthA && j < lengthB)
        {
            if (k % 2 == 0)
            {
                combined.append(a.charAt(i));
                i++;
            }
            else
            {
                combined.append(b.charAt(j));
                j++;
            }
            k++;
        }

        if (i == lengthA)
        {
            while (j < lengthB)
            {
                combined.append(b.charAt(j));
                j++;
            }
        }
        else {
            while (i < lengthA)
            {
                combined.append(a.charAt(i));
                i++;
            }
        }
        return combined.toString();
    }
}
