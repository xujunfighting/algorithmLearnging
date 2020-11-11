package com.zto.sort;

/**
 * Created by xujun on 2018-10-26.
 */
public class SelectSort {
    public static void main(String[] args){
        int[] a=new int[]{8,7,6,5,4,3,2,1};
        a=sort(a);
        print(a);
    }
    public static int[] sort(int[] a){
        int min=0;
        int index=0;
        for(int i=0;i<a.length-1;i++){
            min=a[i];
            index=i;
            for (int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min=a[j];
                    index=j;
                }
            }
            int temp=a[i];
            a[i]=a[index];
            a[index]=temp;

        }
        return a;
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
