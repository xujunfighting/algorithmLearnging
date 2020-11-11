package com.zto.algorithm;

import java.util.Scanner;

/**
 * Created by xujun on 2018-11-05.
 */
public class StringAllSequence {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String test=scanner.next();
            char[] chars=test.toCharArray();
            allSequence(chars,0);
        }
    }
    public static void allSequence(char[] chars,int startIndex){
        if(startIndex==chars.length){
            System.out.print(new String(chars));
            System.out.println();
        }else{
            for(int i=startIndex;i<chars.length;i++){
                swap(chars,startIndex,i);
                allSequence(chars,startIndex+1);
                swap(chars,startIndex,i);
            }
        }
    }
    public static void  swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
