package com.zto.sort;

/**
 * Created by xujun on 2018-10-26.
 */
public class ShellSort {
    public static void main(String[] args){
        int a[]=new int[]{1,5,6,7,8,2,3,4,10,14,11,12,13,9};
       a=sort(a);
        print(a);
        //System.out.print(7/2);
    }
    public static int[] sort(int[] a){
        for(int i=a.length/2;i>=1;i--){
            for(int j=0;j<a.length;j++){
                if(j+i>a.length){
                    break;
                }
             if(j+i<a.length&&a[j]>a[j+i]){
                   int temp=a[j];
                   a[j]=a[j+i];
                   a[j+i]=temp;
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
