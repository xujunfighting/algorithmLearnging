package com.middle;


public class ApparenceMoreThanHalf {
    public static void main(String[] args) {
        int[] res=new int[]{4,3,2,6,7,1,5};
        quickSort(res,0,res.length-1);
        System.out.println(res);
    }
    public int MoreThanHalfNum_Solution(int [] array) {
       quickSort(array,0,array.length-1);
       return array[array.length/2];
    }
    public static void quickSort(int[] arr,int start,int end){
        if(start>end){
            return;
        }
        int left=start;
        int right=end;
        int index=arr[left];
        while(left<right){
            while(right>left&&arr[right]>=index){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<index){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=index;
        quickSort(arr, start, left - 1);
        quickSort(arr,left+1,end);
    }
    public static void swap(int arr[],int p,int q){
        int swap=arr[p];
        arr[p]=arr[q];
        arr[q]=swap;
    }
}
