package com.zto.newYear;

/**
 * Created by xujun on 2019-01-10.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] a=new int[]{1,4,3,2,5,10,9,7,8};
         method(a,0,a.length-1);
         print(a);
    }
    public static void method(int[] a,int start,int end){
        if(start>=end){
            return;
        }
        int middle=(start+end)/2;
        method(a,start,middle);
        method(a,middle+1,end);
        mergeSort(a,start,middle,end);
        //print(a);
    }
    public static void mergeSort(int[] a,int start1,int middle,int end){
        int start2=middle+1;
        int index=start1;
        int[] b=new int[end-start1+1];
        int i=0;
        while(start1<=middle&&start2<=end){
            if(a[start1]<=a[start2]){
                b[i++]=a[start1];
                start1++;
            }else{
                b[i++]=a[start2];
                start2++;
            }
        }
        while(start1<=middle){
            b[i++]=a[start1];
            start1++;
        }
        while(start2<=end){
            b[i++]=a[start2];
            start2++;
        }
        i=0;
        for(i=0;i<b.length;i++){
            a[index+i]=b[i];
        }
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
