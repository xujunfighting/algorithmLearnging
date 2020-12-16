package com.niuke;

public class FindNthUglyNum {
    public static void main(String[] args) {
        int result = getResult(7);
        System.out.println(result);
    }
    public static int getResult(int num){
        int[] indexs=new int[num];
        indexs[0]=1;
        for(int i=1;i<num;i++){
            int compare=indexs[i-1];
           for(int j=0;j<i;j++){
               int min=0;
               if(indexs[j]*2>compare) {
                   min= Math.min(Math.min(indexs[j] * 2, indexs[j] * 3), indexs[j] * 5);
               }else if(indexs[j]*3>compare){
                   min=Math.min(indexs[j]*3,indexs[j]*5);
               }else if(indexs[j]*5>compare){
                   min=indexs[j]*5;
               }
               if(indexs[i]==0){
                   indexs[i]=min;
               }else if(min>compare&&min<indexs[i]){
                   indexs[i]=min;
               }
           }
        }
        return indexs[num-1];
    }
}
