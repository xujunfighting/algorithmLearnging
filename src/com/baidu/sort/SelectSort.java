package com.baidu.sort;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/28
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9,10,11};
        method(nums);
        print(nums);
    }
    public static void method(int[] nums){
        int min=0;
        int swap=0;
        int index=0;
        for(int i=0;i<nums.length-1;i++){
            min=nums[i];
            index=i;
            if(nums[i+1]>nums[i]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(min>nums[j]){
                    min=nums[j];
                    index=j;
                }
            }
            swap=nums[i];
            nums[i]=min;
            nums[index]=swap;
            print(nums);
        }
    }
    public static void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
