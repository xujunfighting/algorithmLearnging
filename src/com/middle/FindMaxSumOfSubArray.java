package com.middle;

public class FindMaxSumOfSubArray {
    public static void main(String[] args) {
        int[] arr=new int[]{-2,-8,-1,-5,-9};
        int result = getResult(arr);
        System.out.println(result);

    }
    public static int getResult(int[] array){
        int max=array[0];
        int result=array[0];
        for(int i=1;i<array.length;i++){
             max+=array[i];
             if(result<max){
                 result=max;
             }else{
                 if(max<0)
                 max=0;
             }
        }
        return result;
    }
}
