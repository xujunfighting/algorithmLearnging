package com.leetcode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/22
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums=new int[]{7,1,2,9,10};
        int maxProfit = getMaxProfit(nums);
        System.out.println(maxProfit);
    }
    public static int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i-1];
            if (profit > 0) maxProfit += profit;
    }
        return maxProfit;
    }
    public static int getMaxProfit1(int[] v){
        int len = v.length;
        int dp = 0;
        int ans = 0;
        for(int i=1;i<len;i++) {
            if(dp<0)
                dp = v[i] - v[i-1];
            else
                dp = dp + v[i] - v[i-1];
            if(dp > ans)
                ans = dp;
        }
        return ans;
    }
    public static int max(int a,int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
}
