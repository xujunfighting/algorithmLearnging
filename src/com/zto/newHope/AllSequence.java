package com.zto.newHope;

/**
 * Author xujun
 * Create date 2019-06-06.
 * desc:
 */
public class AllSequence {
    public static void main(String[] args) {
        String str="abc";
        char[] chars=str.toCharArray();
        printAllSequence(chars,0);
    }
    public static void printAllSequence(char[] chars,int index){
        if(index==chars.length){
            print(chars);
            return;
        }
        for(int i=index;i<chars.length;i++){
            swap(i,index,chars);
            index++;
            printAllSequence(chars,index);
            index--;
            swap(i,index,chars);
        }
    }
    public static void print(char[] chars){
       for(int i=0;i<chars.length;i++){
           System.out.print(chars[i]+"");
       }
        System.out.println();
    }
    public static void swap(int p,int q,char[] chars){
        char temp=chars[p];
        chars[p]=chars[q];
        chars[q]=temp;
    }
}
