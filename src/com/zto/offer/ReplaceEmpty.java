package com.zto.offer;

import java.util.Scanner;

/**
 * Created by xujun on 2018-11-26.
 */
public class ReplaceEmpty {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.print(method(str));
    }
    public static String method(String s){
        String result=null;
        if(s==null){
            return null;
        }
        char[] chars=s.toCharArray();
        int i=0;
        int num_space=0;
        while(i<chars.length){
            if(String.valueOf(chars[i]).equals(" ")){
                num_space++;
            }
            i++;
        }
        int new_lengh=i*2+num_space;
        char[] new_chars=new char[new_lengh];
        i=i-1;
        new_lengh--;
        while(new_lengh>=0&&i>=0){
            if(String.valueOf(chars[i]).equals(" ")){
                new_chars[new_lengh--]='%';
                new_chars[new_lengh--]='2';
                new_chars[new_lengh--]='0';
            }else{
                new_chars[new_lengh--]=chars[i];
            }
           i--;
        }
        result=new String(new_chars);
        return result;
    }
}
