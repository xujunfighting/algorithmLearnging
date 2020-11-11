package com.zto.qdCloud;

/**
 * Author xujun
 * Create date 2019-04-17.
 * desc:
 */
public class AllSequence {
    public static void main(String[] args) {
        String sequence="abc";
        char[] chars=sequence.toCharArray();
        printAllSequence(chars,0,chars.length-1 );
    }



    public static void printAllSequence(char[] chars,int start,int end){
        if(chars.length==0){
            return;
        }
        if(start>=end){
           print(chars);
           return;
        }
        for(int i=start;i<=end;i++){
          swap(chars,i,start);
          start=start+1;
          printAllSequence(chars,start,end);
          start=start-1;
          swap(chars,start,i);
        }
    }
    public static void print(char[] chars){
        for(int i=0;i<chars.length;i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
    public static void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
