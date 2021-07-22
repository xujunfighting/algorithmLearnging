package com.niuke.tree;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/21
 **/
public class AllBinarySearchTreeNum {
    public static void main(String[] args) {
        int result = getResult(4);
        System.out.println(result);

    }
    public static int getResult(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}

