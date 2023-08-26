package com.niuke.array;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/12 09:37
 */
public class DiagonalSum {


    public static void main(String[] args) {
         int[][] nums=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Integer result = getResult(nums);
        System.out.println(result);
    }


    public static Integer getResult(int[][] nums){
        Integer result=0;
        if(nums.length==1){
            result=nums[0][0];
            return result;
        }
        for(int i=0;i<nums.length;i++){
            result+=nums[i][i];
            nums[i][i]=0;
        }
        for(int i=0;i<nums.length;i++){
             result+=nums[i][nums.length-i-1];
        }

        return result;
    }
}
