package com.niuke.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/15
 **/
public class CandidatesSumToTarget {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,5};
        Arrays.sort(nums);
        getResult(nums,8,0);
        System.out.println(lists);
    }
    public static List<List<Integer>> getResult(int[] nums,int target,int start){
        if(target<0){
            return lists;
        }
        if (target==0){
            lists.add(new ArrayList<>(list));
            return lists;
        }
        for(int i=start;i<nums.length;i++){
            if(target-nums[i]<0){
                return lists;
            }
            target-=nums[i];
            list.add(nums[i]);
            getResult(nums,target,i);
            list.remove(list.size()-1);
            target+=nums[i];
        }
        return lists;
    }
}
