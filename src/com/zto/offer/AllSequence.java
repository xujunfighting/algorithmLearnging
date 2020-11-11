package com.zto.offer;

/**
 * Created by xujun on 2018-12-05.
 */
public class AllSequence {
    public static void main(String[] args){
        String[] seq=new String[]{"a","b","c","d"};
        method(seq,0);
    }
    public static void method(String[] seq,int start){
        if(start>=seq.length){
            print(seq);
            return;
        }
      for(int  i=start;i<seq.length;i++){
          swap(seq,start,i);
          method(seq,start+1);
          swap(seq,start,i);
      }
    }
    public static void swap(String[] seq,int i,int j){
        String temp=seq[i];
        seq[i]=seq[j];
        seq[j]=temp;
    }
    public static void print(String[] strs){
        for(int i=0;i<strs.length;i++){
            System.out.print(strs[i]+" ");
        }
        System.out.println();
    }
}
