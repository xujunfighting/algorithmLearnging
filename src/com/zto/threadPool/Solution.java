package com.zto.threadPool;

/**
 * Created by xujun on 2019-02-03.
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];
        boolean result=false;
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }

        }
        return a;
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,4,5};
        int[] b=twoSum(a,6);
    }
}
