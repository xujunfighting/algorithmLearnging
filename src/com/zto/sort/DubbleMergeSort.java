package com.zto.sort;

/**
 * Created by xujun on 2018-11-05.
 */
public class DubbleMergeSort {
    public static  int count=0;
    public static void main(String[] args){
        int[] a=new int[]{9,8,1,4,5,2,3};
        sort(a,0,6);
        print(a);
        System.out.print(count);
    }
    public static void sort(int[] a,int start,int end){
        if(start==end){
            return;
        }
        int mid=(start+end)/2;
        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,mid,end);
    }
    public static void merge(int[] a,int start,int mid,int end){
      int index1=start;
      int index2=mid+1;
      int[] arr=new int[end-start+1];
      int i=0;
       while(index1<=mid&&index2<=end){
          if(a[index1]<a[index2]){
              count+=mid-i+1;
              arr[i++]=a[index1];
              index1++;
          }else{
              arr[i++]=a[index2];
              index2++;
          }
       }
       while(index1<=mid){
           arr[i++]=a[index1++];
       }
       while(index2<=end){
           arr[i++]=a[index2++];
       }
       i=0;
       while(start<=end){
           a[start]=arr[i];
           start++;
           i++;
       }
    }
    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
