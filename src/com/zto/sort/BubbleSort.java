package com.zto.sort;

/**
 * Created by xujun on 2018-10-26.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] a=new int[]{1,4,5,6,2,3};
        a=sort(a);
        print(a);
    }
    public static int[] sort(int[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<=i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
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
