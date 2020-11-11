package com.zto.sort;

/**
 * Created by xujun on 2018-11-14.
 */
public class MyMergeSort {
    public static void main(String[] args){
        int[] a=new int[]{4,8,5,3,1,2,3};
         //sort(a);
         MergeSort2.MergeSort2(a);
         InsertSort.print(a);
    }
    public static void sort(int[] a){
        for(int i=1;i<a.length;i=i*2){
            System.out.println("当前步长为:"+i);
            int j=0;
            while(j+2*i-1<a.length) {
                merge(a, j, j + i - 1, j + 2 * i - 1);
                j += i * 2;
            }
            if(j+i<a.length){
                System.out.println("出现落单元素，开始位置为:"+j);
                merge(a,j,j+i-1,a.length-1);
            }
            }
        }
    public static void merge(int[] a,int start,int mid,int end){
        int index1=start;
        int index2=mid+1;
        int[] arr=new int[end-start+1];
        int i=0;
        while(index1<=mid&&index2<=end){
            if(a[index1]<a[index2]){
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
}


