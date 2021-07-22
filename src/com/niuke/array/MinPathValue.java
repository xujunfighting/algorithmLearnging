package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/21
 **/
public class MinPathValue {
    public static void main(String[] args) {
         int[][] nums=new int[][]{{1,3,1},{1,5,1}};
        int result = getResult(nums);
        System.out.println(result);
    }
    public static int getResult(int[][] nums){
        int[][] results=new int[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                if(i==0&&j==0){
                    results[i][j]=nums[i][j];
                }else if(i==0){
                    results[i][j]=results[i][j-1]+nums[i][j];
                }else if(j==0){
                    results[i][j]=results[i-1][j]+nums[i][j];
                }else{
                    results[i][j]=Math.min(results[i-1][j],results[i][j-1])+nums[i][j];
                }
            }
        }
        return results[nums.length-1][nums[0].length-1];
    }
}
