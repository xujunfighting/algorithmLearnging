package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-21.
 */
public class MoneyChoose {
    public static void solve(int n)
    {
        //dp[i][j]:表示只使用p[1]~p[i]中的值凑成成j，能有多少种情况
        int[] p={0,1,5,10,20};
        int[][] dp=new int[p.length][n+1];
        for(int i=0;i<=n;i++)
        {
            dp[1][i]=1;
        }
        for(int i=1;i<p.length;i++)
        {
            dp[i][0]=1;
        }
        for(int i=2;i<p.length;i++)
        {
            for(int j=1;j<=n;j++)
            {
                for(int k=0;k<=n;k++)
                {
                    if(j-p[i]*k>=0)
                        dp[i][j]+=dp[i-1][j-p[i]*k];
                    else
                        break;
                }
            }
        }
        System.out.println(dp[p.length-1][n]);
    }
    public static int count(int[] coins,int n){
        int[][] dp = new int[coins.length+1][n+1];
        for(int i=0;i<coins.length+1;i++)
            dp[i][0] = 1;	//初始化，用前i种面值组合成0的方案为1

        for(int i=1;i<=coins.length;i++)
            for(int j=1;j<=n;j++)
            for(int k=0;k<=j/coins[i-1];k++)
                dp[i][j] += dp[i-1][j-k*coins[i-1]];

        return dp[coins.length][n];
    }
    public static void main(String[] args){
        int[] c=new int[]{1,2,5,10};
        int result=count(c,20);
        System.out.println(result);
    }
}
