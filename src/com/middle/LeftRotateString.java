package com.middle;

public class LeftRotateString {
    public static void main(String[] args) {
        String str="abcXYZdef";
        String res=LeftRotateString(str,3);
        System.out.println(res);
    }
    public static String LeftRotateString(String str,int n) {
         n=n%str.length();
         String str1=str.substring(0,n);
         String str2=str.substring(n);
         return str2+str1;
    }
}
