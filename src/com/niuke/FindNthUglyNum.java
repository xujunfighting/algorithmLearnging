package com.niuke;

import java.util.HashMap;

public class FindNthUglyNum {
    public static void main(String[] args) {
        int result = getResult2(7);
        System.out.println(result);
    }
    public static int getResult1(int num){
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
    public static int getResult2(int num){
        int[] indexs=new int[num];
        indexs[0]=1;
        int start=1;
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        m.put(start,start);
        for(int i=1;i<num;i++){
            boolean isGet=false;
            while(!isGet){
                start++;
                if((start%2==0&&m.containsKey(start/2))||(start%3==0&&m.containsKey(start/3))||(start%5==0&&m.containsKey(start/5))){
                    indexs[i]=start;
                    isGet=true;
                    m.put(start,start);
                }
            }
        }
        return indexs[num-1];
    }
}
