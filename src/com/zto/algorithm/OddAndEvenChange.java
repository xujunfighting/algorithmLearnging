package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-28.
 */
public class OddAndEvenChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res =getChangeArray(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    public static int[] getChangeArray(int [] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            while(start<end&&arr[start]%2==1){
                start++;
            }
            while(start<end&&arr[end]%2==0){
                end--;
            }
            int tmp=arr[end];
            arr[end]=arr[start];
            arr[start]=tmp;
        }
        return arr;
    }
}
