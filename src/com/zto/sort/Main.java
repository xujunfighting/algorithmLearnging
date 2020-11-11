package com.zto.sort;

import java.util.Random;

/**
 * Created by xujun on 2018-11-14.
 */
public class Main {
    public static void main(String[] args){
        int[] a=getRandomResult(10000,10);
        long start=System.currentTimeMillis();
        QuickSort.sort1(a,0,a.length-1);
        System.out.println(System.currentTimeMillis()-start+"ms");
        print(a);
//          Random ran=new Random();
//          int start=10;
//          int end=100;
//         int index=ran.nextInt(end-start)+start;
//         System.out.print(index);
    }
    public static int[] getRandomResult(int num,int  max){
        Random random=new Random();
        int[] a=new int[num];
        for(int i=0;i<num;i++){
              a[i]=random.nextInt(max+1);
        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

}
