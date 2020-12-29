package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/29
 */
public class FindAbsentValue {
    public static void main(String[] args) {
        int[] res=new int[]{0,1,2,3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int result = getResult(res);
        System.out.println(result);

    }
    public static int getResult(int[] nums){
        int start=nums[0];
        int end=nums[nums.length-1];
        int sum=0;
        sum=(start+end)*(nums.length+1)/2;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
}
