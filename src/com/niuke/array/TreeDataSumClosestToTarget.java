package com.niuke.array;

import java.util.Arrays;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/7
 **/
public class TreeDataSumClosestToTarget {
    public static void main(String[] args) {
//        输入：nums = [-4,-1,1,2], target = 1
//        输出：2
//        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
           int[] ints=new int[]{1,2,5,10,11};
        int result = getResult(ints, 12);
        System.out.println(result);
    }
    public static int getResult(int[] nums,int target){
        int result=2000;
        Arrays.sort(nums);
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        int cur=0;
        int start=0;
        int end=0;
        for(int i=0;i<nums.length-2;i++){
            cur=target;
            cur-=nums[i];
            start=i+1;
            end=nums.length-1;
           while(start<end){
               if(Math.abs(target-result)>Math.abs(target-nums[i]-nums[start]-nums[end])){
                   result=nums[i]+nums[start]+nums[end];
               }
               if(cur-nums[start]-nums[end]==0){
                   return target;
               }else if(cur-nums[start]-nums[end]>0){
                   start++;
               }else if(cur-nums[start]-nums[end]<0){
                   end--;
               }

           }
        }

        return result;
    }
}
