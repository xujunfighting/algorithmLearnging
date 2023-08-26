package com.niuke.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/13 14:04
 */
public class MinimumSeconds {

    public static void main(String[] args) {
         List<Integer> nums=new ArrayList<>();
         nums.add(1);
         nums.add(2);
         nums.add(1);
         nums.add(2);
        int result = getResult(nums);
        System.out.println(result);

    }

    public static int getResult(List<Integer> nums){
        int result=0;
        int maxCountVal=0;
        int maxCount=0;
        Map<Integer,List<Integer>> maps=new HashMap<>();
        for(int i=0;i<nums.size();i++){
           if(!maps.containsKey(nums.get(i))){
               List<Integer> lists=new ArrayList<>();
               lists.add(i);
               maps.put(nums.get(i),lists);
           }else{
               List<Integer> lists = maps.get(nums.get(i));
               lists.add(i);
               maps.put(nums.get(i),lists);
           }

           if(maps.get(nums.get(i)).size()>maxCount){
               maxCount=maps.get(nums.get(i)).size();
               maxCountVal=nums.get(i);
           }
        }
        if(maxCount==nums.size()){
            return 0;
        }
        int maxLen=0;
        int curMaxlen=0;
        List<Integer> lists=maps.get(maxCountVal);

        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==maxCountVal){
                continue;
            }

            for(int j=0;j<lists.size();j++){
               curMaxlen=Math.abs(i-lists.get(j));
               if(maxLen<curMaxlen){
                   maxLen=curMaxlen;
               }
            }
        }


        return maxLen;
    }
}
