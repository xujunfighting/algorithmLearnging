package com.niuke.array;

import java.util.*;

/**
 * @Author xujun
 * @Description
 * @Date 2023/10/28 14:43
 */
public class MinGroupsForValidAssignment {
    public static void main(String[] args) {
        int[] nums=new int[]{2,1,1,2,2,3,1,3,1,1,1,1,2};
        // 7 4 2
        // 2 2 2 1 2 2 1
        int result = getResult(nums);
        System.out.println(result);
    }

    public static int getResult(int[] nums){
        int res=0;
        Map<Integer,Integer> maps=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!maps.containsKey(nums[i])){
                maps.put(nums[i],1);
            }else {
                Integer count = maps.get(nums[i]);
                maps.put(nums[i],count+1);
            }
        }
        Integer minCount=Integer.MAX_VALUE;
        List<Integer> values=new ArrayList<>();
        for(Map.Entry<Integer,Integer> set:maps.entrySet()){
            Integer value = set.getValue();
            if(value<minCount){
                minCount=value;
            }
            values.add(value);
        }
       boolean flag=false;
        for(int i=minCount;i>=1;i--){
            int totalCount=0;
            flag=false;
            for(Integer v:values){
               if(v%i!=0&&v%(i+1)!=0&&v%(i+1)!=i){
                   flag=true;
                   break;
               }
               if(v%(i+1)==0){
                  totalCount+=v/(i+1);
               }else if(v%(i+1)==i||v%i==0){
                     if((v%(i+1)==i)&&(v%i==0)){
                         totalCount+=Math.min(v/i,v/(i+1)+1);
                     }else if(v%(i+1)==i){
                         totalCount+=v/(i+1)+1;
                     }else{
                         totalCount+=v/i;
                     }
               }
            }
            if(!flag){
                return totalCount;
            }
        }

        return res;
    }
}
