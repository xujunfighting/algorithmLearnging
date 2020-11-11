package com.huawei;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st="asdbuiodevauufgh";
            getResult(st);
    }
    public static void getResult(String strs){
        int max=0;
        int result=0;
        if(strs.length()==0){
            System.out.println(0);
        }
        char[] chars=strs.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='a'||chars[i]=='e'||chars[i]=='i'||chars[i]=='u'||chars[i]=='o'||chars[i]=='A'||chars[i]=='E'||chars[i]=='I'||chars[i]=='U'||chars[i]=='O'){
                while(i<chars.length&&(chars[i]=='a'||chars[i]=='i'||chars[i]=='e'||chars[i]=='u'||chars[i]=='o'||chars[i]=='A'||chars[i]=='E'||chars[i]=='I'||chars[i]=='U'||chars[i]=='O')){
                    max++;
                    i++;
                }
                if(max>result){
                    result=max;
                }
                max=0;
            }
        }
        System.out.println(result);
    }
}
