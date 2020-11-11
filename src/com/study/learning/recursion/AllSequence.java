package com.study.learning.recursion;

/**
 * Author xujun
 * Create date 2019-12-30.
 * desc:
 */
public class AllSequence {
    public static void main(String[] args) {
        String sequence="ABC";
        method(sequence.toCharArray(),0);
    }
    public static void method(char[] chars,int start){
       if(start>=chars.length){
           print(chars);

       }
       for(int i=start;i<chars.length;i++){
             swap(chars,i,start);
             method(chars,start+1);
             swap(chars,start,i);
       }
    }
    public static void swap(char[] chars,int p,int q){
        char temp=chars[p];
        chars[p]=chars[q];
        chars[q]=temp;
    }
    public static void print(char[] chars){
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
