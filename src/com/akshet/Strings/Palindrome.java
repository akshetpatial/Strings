package com.akshet.Strings;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String input){

        int start=0;
        int end = input.length()-1;

        while(start<=end){
            if(input.charAt(start)!=input.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter any String: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        boolean check = isPalindrome(input);
        if(check)
            System.out.println(input+ " is a Palindrome");
        else
            System.out.println(input+ " is not a Palindrome");

    }
}
