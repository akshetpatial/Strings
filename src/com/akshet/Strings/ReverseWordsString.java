package com.akshet.Strings;

import java.util.Scanner;

public class ReverseWordsString {

    private static String reverseWord(String word) {
        int len = word.length();
        int index = len-1;
        String ans = "";
        while(index>=0){
            ans+=word.charAt(index);
            index--;
        }
        return ans;
    }


    public static String removeInitialSpace(String str){
        StringBuffer sb = new StringBuffer(str);
        int index =0;
        int sbIndex= 0 ;
        while(index<str.length()){
            if(str.charAt(index)==' ') {
                sbIndex++;
                index++;
            }
            else
                break;
        }
        String str_1 = sb.substring(sbIndex);
        return str_1;
    }
    public static String reverseString(String str){

        String str_1 = removeInitialSpace(str);
        int len = str_1.length();
        int index = len-1;
        String ans = "";
        String word= "";
        boolean check = false;
        while (index >= 0) {
            if (str_1.charAt(index) == ' ') {
                if(check){
                    if(index!=0) {
                        String rev = reverseWord(word);
                        ans += rev + " ";
                    }else{
                        String rev = reverseWord(word);
                        ans += rev;
                    }
                }
                check = false;
                word="";
                index--;
            }else{
                check = true;
                word+=str_1.charAt(index);
                index--;
            }
        }
        return ans+reverseWord(word);
    }

    public static String reverseInBuiltString(String str){

        String[] ans = str.split(" ");
        StringBuffer sb = new StringBuffer();
        System.out.println(ans.length);
        for(int index = ans.length-1; index>=0;index--){
            if(!ans[index].isEmpty())
                sb.append(ans[index]+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter new String: "); //    akshet is a   good   boy
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String ans = reverseString(str);
        System.out.println("\n"+ans);
        String ans_1= reverseInBuiltString(str);
        System.out.println(ans_1);
    }
}
