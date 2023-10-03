package com.akshet.Strings;

import java.util.Scanner;

public class CountAnagram {

    private static String[] printAllAnagram(String str) {

        int len = str.length();
        int factorial = fact(len);
        System.out.println(factorial);

        String st[] = new String[factorial];
        return helperFunc("",str,st,0,factorial);
    }

    private static String[] helperFunc(String add, String ignore, String[] st,int count, int len) {
        if(ignore.isEmpty()) {
            st[count] = add;
            return st;
        }

        add+= ignore.substring(0,1);
        return helperFunc(add, ignore.substring(1),st,count,len);
    }

    private static int fact(int len) {
        if(len ==0 )
            return 1;
        if(len == 1 || len ==2)
            return len;

        return len * fact(len-1);
    }

    public static void main(String[] args) {
        System.out.println("Enter new String: "); //    for akshet
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] ans = printAllAnagram(str);
        System.out.println("All Anagram");
        for(String st : ans ) {
            System.out.print(st+", ");
        }
        System.out.println();
    }

}
