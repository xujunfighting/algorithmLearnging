package com.zto.test;

/**
 * Created by xujun on 2018-12-26.
 */
public class Ways3QuickSort {
    public static void  main(String[] args){
        int[] a=new int[]{3,2,1,4,0,9,8};
        a=method(a,0,a.length-1);
        print(a);
    }
    public static int[] method(int[] a,int start,int end){
        int index=a[start];
        int i=start;
        int lt=start;
        int gt=end+1;
        while(i<gt){
            if(index>a[i]){

            }else if(index<a[i]){

            }else{
                i++;
            }
        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
