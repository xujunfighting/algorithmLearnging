package com.zto.newYear;

/**
 * Created by xujun on 2019-01-08.
 */
public class OneWaysQuickSort {
    public static void main(String[] args){
        int[] a=new int[]{3,4,2,1,6,7,9,8,11,10,14};
        method(a,0,a.length-1);
        print(a);
    }
    public static void method(int[] a,int start,int end){
        if(start>=end){
            return;
        }
        int index=start;
        int i=start+1;
        int j=start+1;
        while(i<=end){
            if(a[i]<a[index]){
                int temp=a[i];
                a[i]=a[j];
                a[j++]=temp;
            }
            i++;
        }
        int temp=a[index];
        a[index]=a[j-1];
        a[j-1]=temp;
        method(a,start,j-2);
        method(a,j,end);
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
