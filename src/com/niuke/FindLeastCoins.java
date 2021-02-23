package com.niuke;

public class FindLeastCoins {
    private static int result=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] array=new int[]{3,2,4,5};
        getResult(array,11,0);
        System.out.println(result);
    }
    public static void getResult(int[] array,int target,int num){
        if(target<0){
            return;
        }
        if(target==0&&num<result){
            result=num;
            return;
        }
        for(int i=array.length-1;i>=0;i--){
            target-=array[i];
            getResult(array,target,num+1);
            target+=array[i];
        }
    }

}
