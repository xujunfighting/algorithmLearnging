package com.zto.charjump;

import java.util.ArrayList;
import java.util.List;

/**
 * Author xujun
 * Create date 2019-03-05.
 * desc:
 */
class Solution1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        List<Integer> temp=new ArrayList<>(list);
                        lists.add(temp);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] ints=new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists=threeSum(ints);
        System.out.println(lists);
    }
}

