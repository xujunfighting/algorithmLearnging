package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-30.
 * desc:
 */
public class AllSequenceList {
    public static void main(String[] args) {
        String sequence="abc";
        method(sequence.toCharArray(),0);
    }
    public static void method(char[] chars,int index){
        if(chars.length-1==index){
            print(chars);
        }
        for(int i=index;i<chars.length;i++){
            swap(chars,i,index);
            index++;
            method(chars,index);
            index--;
            swap(chars,index,i);
        }
    }
    public static char[] swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        return chars;
    }
    public static void print(char[] chars){
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]+" ");
        }
        System.out.println();
    }
}
