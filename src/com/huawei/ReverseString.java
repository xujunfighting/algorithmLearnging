package com.huawei;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String res=scanner.nextLine();
        String result = getResult(res);
        System.out.println(result);
    }
    public static String getResult(String res){
        StringBuffer sb=new StringBuffer(200);
        char[] chars = res.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
