package com.middle;

import java.util.ArrayList;

public class FindSumWithResult {
    public static void main(String[] args) {
       int[] array=new int[]{1,2,3,4,5,6,7};
        ArrayList<Integer> res=getResult(array,8);
        System.out.println(res);
    }
    public static ArrayList<Integer> getResult(int[] array, int sum){
        int start=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        int end=array.length-1;
        int result=Integer.MAX_VALUE;
        int res=0;
        while(start<end){
            if(array[start]+array[end]==sum){
                res=array[start]*array[end];
                if(res<result){
                    result=res;
                    arrayList=new ArrayList<>();
                    arrayList.add(array[start]);
                    arrayList.add(array[end]);
                }
                start++;
                end--;
            }else if(array[start]+array[end]>sum){
                   end--;
            }else if(array[start]+array[end]<sum){
                  start++;
            }
        }
        return  arrayList;
    }
}
