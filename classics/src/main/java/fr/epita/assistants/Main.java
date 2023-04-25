package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        System.out.println(Classics.factorial(5));
        System.out.println(Classics.factorial(0));
        System.out.println(Classics.factorial(-1));
        System.out.println(Classics.factorial(1));
        for (int i = 0; i < 10; i++) {
            System.out.print("fibo(" + i + ") = ");
            System.out.println(Classics.tribonacci(i));
        }
        System.out.println(Classics.isPalindrome("abcCBA"));
        System.out.println(Classics.isPalindrome("abcC B A"));

        System.out.println(Classics.combine("abc", "def"));
    }
}
