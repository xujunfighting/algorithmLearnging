package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/20
 **/
public class AllPathsInBinaryArrayWithObstacles {
    public static void main(String[] args) {
        //[
        // [0,0,1,0,0],
        // [0,1,0,0,0],
        // [1,0,0,0,0],
        // [0,0,0,0,0]
        // ]
        int[][] nums=new int[][]{{0,0,1,0,0},{0,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0}};
        int result = getResult(nums);
        System.out.println(result);

    }
    public static int getResult(int[][] nums){
        int[][] results=new int[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(i==0&&j==0){
                    if(nums[0][0]==1){
                        /**
                         * 第一个节点存在障碍 直接返回 表明不能到达目的地
                         */
                        return 0;
                    }else{
                        results[i][j]=1;
                    }
                }else if(i==0){
                  //j>0
                    if(nums[i][j-1]!=1&&nums[i][j]!=1){
                        /**
                         * 当前节点不存在障碍且前面的节点不存在障碍 继承上个节点的到达情况
                         */
                        results[i][j]=results[i][j-1];
                    }
                }else if(j==0){
                    //i>0
                    if(nums[i-1][j]!=1&&nums[i][j]!=1){
                        /**
                         * 当前节点不存在障碍且前面的节点不存在障碍 继承上个节点的到达情况
                         */
                        results[i][j]=results[i-1][j];
                    }
                }else{
                    if(nums[i][j]==1){
                        /**
                         * 当前节点存在障碍
                         */
                        results[i][j]=0;
                    }else if(nums[i][j-1]!=1&&nums[i-1][j]!=1){
                        /**
                         * 当前节点可到达 且上个左边和上边的节点都是可达
                         */
                        results[i][j]=results[i-1][j]+results[i][j-1];
                    }else if(nums[i][j-1]==0){
                        /**
                         * 上边节点可达
                         */
                        results[i][j]=results[i][j-1];
                    }else if(nums[i-1][j]==0){
                        /**
                         * 左边节点可达
                         */
                        results[i][j]=results[i-1][j];
                    }
                }
            }
        }
        return results[nums.length-1][nums[0].length-1];
    }
}
