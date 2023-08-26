package com.niuke.array;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/12 16:43
 */
public class MaxAbsoluteSum {
    public static void main(String[] args) {
         //1 2 3 -1 2 -9
        int[] result=new int[]{2,-5,1,-4,3,-2};
        int result1 = getResult(result);
        System.out.println(result1);
    }

    /**
     * -5 1 -4   -5加1以后总值还是小于0  和-4相加 累计值增大
     * @param nums
     * @return
     */

    public static int getResult(int[] nums){
        int positiveMax = 0, negativeMin = 0;
        int positiveSum = 0, negativeSum = 0;
        for (int num : nums) {
            //累加当前值
            positiveSum += num;
            //判断当前值是大于累计最大值  如果是替换
            positiveMax = Math.max(positiveMax, positiveSum);
            //累加值小于0以后直接重置
            positiveSum = Math.max(0, positiveSum);
            negativeSum += num;
            negativeMin = Math.min(negativeMin, negativeSum);
            //累加和大于0后直接重置
            negativeSum = Math.min(0, negativeSum);
        }
        return Math.max(positiveMax, -negativeMin);

    }
}
