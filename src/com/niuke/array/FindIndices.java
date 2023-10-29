package com.niuke.array;

/**
 * @Author xujun
 * @Description 2903
 * @Date 2023/10/22 09:22
 */
public class FindIndices {
    public static void main(String[] args) {

    }


    public int[] getResult(int[] nums, int indexDifference, int valueDifference){
        int[] res=new int[]{-1,-1};
        if(nums.length-1<indexDifference){
            return res;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>=i;j--){
                if(Math.abs(i-j)>=indexDifference&&Math.abs(nums[i]-nums[j])>=valueDifference){
                    return new int[]{i,j};
                }
            }
        }
        return res;
    }


}
