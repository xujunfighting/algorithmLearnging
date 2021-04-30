package com.niuke;

public class DropBallFromHighBuilding {
    public static void main(String[] args) {
        //int result = getResult(105, 2);
        //System.out.println(result);
        getTwoBallResult(105);

    }
    //dp[k,n]=max(dp[k-1,i-1],dp[k,n-i])+1
    // layer 表示层数
    // num 表示小球的个数

    /**
     * 如果小球在k层碎 考虑k层以下 且小球的数目减1
     * 如果小球在k层不碎 考虑k+1层 且小球数目维持原来的数目
     * 当前的尝试次数为1
     * @param layer
     * @param num
     * @return
     */
    public static int getResult(int layer,int num){
        if(layer==0){
            return 0;
        }
        if(num==1){
            return layer;
        }
        int[][] dp=new int[num+1][layer+1];

            for(int i=1;i<num+1;i++){
                int min = Integer.MAX_VALUE;
             for(int j=1;j<layer+1;j++){
                for(int k=1; k<=j; ++k) {
                    min = Math.min(min, Math.max(dp[i-1][j-1], dp[i][layer-j]))+1;
                }
                dp[i][j] = min ;
            }
        }
        return dp[num][layer];
    }

    public static int getTwoBallResult(int building){


        int[] dp = new int[building+1];

        for (int i = 2;i <=building;i++){

            int Min = building;

            for (int j = 1;j < i;j++){

                int Max = dp[i-j]+1;

                if (Max < j){
                    Max = j;
                }

                if (Max < Min){
                    Min = Max;
                }
            }
            dp[i] = Min;
        }
        System.out.println(dp[building]);
        return dp[building];

    }
}
