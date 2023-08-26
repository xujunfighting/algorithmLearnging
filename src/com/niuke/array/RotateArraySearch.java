package com.niuke.array;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/19 13:40
 */
public class RotateArraySearch {


    public static void main(String[] args) {
         int[] nums=new int[]{0,0,1,1,2,0};
        boolean result = getResult(nums, 2);
        System.out.println(result);

    }



    public static boolean getResult(int[] nums,int target){
        if(nums.length==1){
            return nums[0]==target;
        }

        int start=0;
        int end=nums.length-1;
        while(start<end){
            if(nums[start]==target||nums[end]==target){
                return true;
            }
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[start]==nums[mid]&&nums[mid]==nums[end]){
                start++;
                end--;
            }else if(target>nums[start]){
                end=mid-1;
            }else if(target<nums[start]){
                start=mid+1;
            }
        }

        if(nums[start]==target){
            return true;
        }
        return false;
    }
}
