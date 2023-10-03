package com.akshet.Strings;

import java.util.*;

public class CountAnagram {

    /* private static String[] printAllAnagram(String str) {

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
    } */

    /*
        Initial Code
    */
    /*private static int countAnagram(String str1, String str2) {
        int i = 0;
        int count =0;

        Map<Character,Integer> targetMap =  new HashMap<Character,Integer>();

        findMapElement(str2,targetMap);

        for(Map.Entry<Character,Integer> mp : targetMap.entrySet()){
            System.out.print("Key: "+mp.getKey() + " Value: "+ mp.getValue()+"\n");
        }System.out.println();

        int j = str2.length()-1;

            while(j!=str1.length()) {
                Map<Character,Integer> rangeMap =  new HashMap<Character,Integer>();
                findMapElement(str1.substring(i, j + 1), rangeMap);
                System.out.println("Range Map having Range between: "+i+" and "+j);
                for(Map.Entry<Character,Integer> mp : rangeMap.entrySet()){
                    System.out.print("Key: "+mp.getKey() + " Value: "+ mp.getValue()+"\n");
                }System.out.println();
                if (rangeMap.equals(targetMap))
                    count++;
                j++;
                i++;
            }
            return count;
    }*/

    /*
    Optimize Code We are not iterating over the map again
   */

    private static int countAnagram(String str1, String str2) {
        int i = 0;
        int count =0;

        Map<Character,Integer> targetMap =  new HashMap<Character,Integer>();

        findMapElement(str2,targetMap);

        for(Map.Entry<Character,Integer> mp : targetMap.entrySet()){
            System.out.print("Key: "+mp.getKey() + " Value: "+ mp.getValue()+"\n");
        }System.out.println();

        int j = str2.length()-1;

        Map<Character,Integer> rangeMap =  new HashMap<Character,Integer>();
        findMapElement(str1.substring(0, j + 1), rangeMap);

        while(j!=str1.length()) {
            System.out.println("Range Map having Range between: "+i+" and "+j);
            for(Map.Entry<Character,Integer> mp : rangeMap.entrySet()){
                System.out.print("Key: "+mp.getKey() + " Value: "+ mp.getValue()+"\n");
            }System.out.println();
            if (rangeMap.equals(targetMap))
                count++;
            rangeMap.put(str1.charAt(i),rangeMap.get(str1.charAt(i))-1);
            i++;
            j++;
            if(j<str1.length())
                rangeMap.put(str1.charAt(j),rangeMap.get(str1.charAt(j))+1);
        }

        List<Map.Entry<Character,Integer>> list  = new ArrayList<>(targetMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Sorted List");
        for(Map.Entry<Character,Integer> m: list){
            System.out.print("Key: "+m.getKey()+ " Value: "+m.getValue()+"\n");
        }

        String st = "";
        int index = list.size()-1;

        while(index>=0){
            int len = list.get(index).getValue();
            while(len!=0){
                st+=list.get(index).getKey();
                len--;
            }
            index--;
        }

        System.out.println("Sort Character by Frequency");
        System.out.println(st);
        return count;
    }

    private static void findMapElement(String str2, Map<Character, Integer> targetMap) {
        for(char ch : str2.toCharArray()){
            if(!targetMap.containsKey(ch))
                targetMap.put(ch,1);
            else
                targetMap.put(ch,targetMap.get(ch)+1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Main String: "); //    aabaabaa
        Scanner scan = new Scanner(System.in);
        String str_1 = scan.nextLine();

        System.out.println("Enter target String: "); //    aaba
        String str_2 = scan.nextLine();

        int ans = countAnagram(str_1,str_2);
        System.out.println("Number of Anagram of the target String "+str_2+" from the given String "+str_1+" is: "+ ans);
    }
}
