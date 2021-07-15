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
public class CandidatesSumToTargetNoDuplicate {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();

    public static void main(String[] args) {
       int[] nums=new int[]{10,1,2,7,6,1,5};
        Arrays.sort(nums);
       getResult(nums,0,8);
        System.out.println(lists);
    }
    public static List<List<Integer>> getResult(int[] nums,int start,int target){
        if(target<0){
            return lists;
        }
        if (target==0){
            lists.add(new ArrayList<>(list));
            return lists;
        }
        int lastNum=0;
        for(int i=start;i<nums.length;i++){
            /**
             * 元素为有序数组 如果目标值减去当前值小于零 后续的值肯定也是小于零 直接跳出当前循环
             */
            if(target-nums[i]<0){
                return lists;
            }
            /**
             * 记录当前层次上次遍历的元素是否和本次遍历的元素相同 相同表示已经添加过 直接跳过当前元素
             */
            if(lastNum==nums[i]){
                continue;
            }
            lastNum=nums[i];
            target-=nums[i];
            list.add(nums[i]);
            getResult(nums,i+1,target);
            list.remove(list.size()-1);
            target+=nums[i];
        }
        return lists;
    }
}
