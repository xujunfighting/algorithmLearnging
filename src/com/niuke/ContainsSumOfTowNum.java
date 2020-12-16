package com.niuke;

import java.util.HashMap;

public class ContainsSumOfTowNum {
    public static void main(String[] args) {
        int[] res=new int[]{0,4,3,0};
        int[] ints = twoSum(res, 0);
        System.out.println(ints);
    }
    public static int[] twoSum(int[] res,int sum){
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
        int[] result=new int[2];
        for(int i=0;i<res.length;i++){
            if(!integerIntegerHashMap.isEmpty()&&integerIntegerHashMap.containsKey(sum-res[i])){
                Integer index = integerIntegerHashMap.get(sum - res[i]);
                if(index>i){
                    result[0]=i+1;
                    result[1]=index+1;
                }else{
                    result[0]=index+1;
                    result[1]=i+1;
                }

            }
            integerIntegerHashMap.put(res[i],i);
        }
        return result;
    }
}
