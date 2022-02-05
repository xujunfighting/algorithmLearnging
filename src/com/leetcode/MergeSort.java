package com.leetcode;

/**
 * @author xujun
 * @date 2022-01-28
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{2,1,4,3};
        merge(arrays, 0, arrays.length-1);
        System.out.println(arrays);
    }

    public static void  merge(int[] arrays,int start,int end){
        if(start>=end){
            return;
        }
        int middle=(start+end)/2;
        merge(arrays,start,middle);
        merge(arrays,middle+1,end);
        mergeSort(arrays,start,middle,middle+1,end);
    }

    public static int[] mergeSort(int[] arrays,int start1,int end1,int start2,int end2){
        int[] results=new int[end2-start2+2+end1-start1];
        int index=0;
        int start=start1;
        while(start1<=end1&&start2<=end2){
            if(arrays[start1]<=arrays[start2]){
                results[index++]=arrays[start1];
                start1++;
            }else{
                results[index++]=arrays[start2];
                start2++;
            }
        }
        while (start1<=end1){
            results[index++]=arrays[start1++];
        }
        while (start2<=end2){
            results[index++]=arrays[start2++];
        }
        for(int i=0;i<results.length;i++){
            arrays[i+start]=results[i];
        }
        return arrays;
    }
}
