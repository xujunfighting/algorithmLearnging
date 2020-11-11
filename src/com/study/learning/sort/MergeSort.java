package com.study.learning.sort;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class MergeSort {
    public static int totalSum=0;
    public static void main(String[] args) {
        int[] num= new int[]{4,8,3,2};
        mergeSort(num,0,num.length-1);
        print(num);
    }
    public static void mergeSort(int[] num,int start,int end){
        if(start>=end){
            return ;
        }
        int middle=(start+end)/2;
        mergeSort(num,start,middle);
        mergeSort(num,middle+1,end);
        method(num,start,middle,middle+1,end);
    }
    public static void method(int[] num,int start1,int end1,int start2,int end2){
        int[] temp=new int[end2-start1+1];
        int index=0;
        int start=start1;
        while(start1<=end1&&start2<=end2){
            if(num[start1]<=num[start2]){
                temp[index++]=num[start1++];
            }else{
                totalSum += end1-start1+1;
                temp[index++]=num[start2++];
            }
        }
        while(start1<=end1){
            temp[index++]=num[start1++];
        }
        while(start2<=end2){
            temp[index++]=num[start2++];
        }
        for(int i=0;i<temp.length;i++){
            num[start+i]=temp[i];
        }
    }
    public static void print(int[] num){
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
