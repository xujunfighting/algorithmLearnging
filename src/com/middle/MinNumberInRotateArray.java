package com.middle;

public class MinNumberInRotateArray {
    public static void main(String[] args) {

    }
    public int minNumberInRotateArray(int[] array){
        if(array.length==0) return 0;
        int result=0;
        for(int i=0;i<array.length;i++){
            if(array[i+1]<array[i]){
                result=array[i+1];
                return result;
            }
        }
        return result;
    }
}
