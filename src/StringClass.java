public class StringClass {

    // Here in both the methods the time complexity is O(N^2) because we are adding the new object every single time.
    // 1+2+3+4+5+6+...+N = (N) * (N+1)/2
    // So to there should be way from which we can make changes the current object only instead of making an object everytime.


    // To solve the above problem we have String Builders and String Buffers
    // They make String mutable hence allow us to make changes on the current Object
    // It increases the performance of the String

    public static String A2ZMethodOneWay(){
        char s ='a';
        String a="";
        while(s<='z'){
            a+=s+" ";
            s++;
        }
        return a;
    }

    public static String A2ZMethodOtherWay(){
       char c;
        String sp="";
        for(int i=0;i<26;i++){
            c= (char) ('a'+i);
            sp+=c+" ";
        }
        return sp;
    }

    // This one is faster and increases the performance significantly
    public static String A2ZMethodStringBuilder(){
        char c;
        StringBuilder sp = new StringBuilder();
        for(int i=0;i<26;i++){
            c= (char) ('a'+i);
            //sp.append(c+" ");
            sp.append(c).append(" ");
        }
        return sp.toString();
    }

    public static void main(String[] args) {

        String name= "akshet";
        System.out.println("my name is: "+name);

        float f = 123456.654f;
        double d = 2432564.348334;
        System.out.println("Rond Off the Number: "+ f);
        System.out.printf("Round off the number %.2f and print my name as well %s",d,name);

        // If we add two characters 'a' + 'b' it will give the output by adding the ASCII values of a and b.
        // If we add two strings "a" + "b" it will give the output by concatenating the two Strings

        System.out.println("\noutput: "+ ('a'+'b'));
        System.out.println("output: "+ "a"+"b");
        System.out.println("output: "+'a'+2); // Here concatenating like String
        System.out.println("output: "+(char) ('a'+2)); // Here adding like characters
        System.out.println("output: "+"a"+2);

        String a2z = A2ZMethodOneWay();
        System.out.println(a2z);
        String a2z_1 = A2ZMethodOtherWay();
        System.out.println(a2z_1);
        String a2z_2 = A2ZMethodStringBuilder();
        System.out.println(a2z_2);
    }

}
