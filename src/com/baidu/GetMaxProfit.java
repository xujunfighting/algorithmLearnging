package com.baidu;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/9
 */
public class GetMaxProfit {
    public static void main(String[] args) {
//        A物品：1kg  6元
//
//        B物品：2kg  10元
//
//        C物品：4kg  12元
          int[] ints=new int[]{1,2,4};
          int[] prices=new int[]{6,10,12};
        int result = getResult(ints, prices, 6);
        System.out.println(result);
    }
    public static int getResult(int[] ints,int[] prices,int value){
        int x=ints.length+1;
        int y=value+1;
        int[][] values=new int[x][y];
        for(int i=0;i<values[0].length;i++){
            values[0][i]=0;
        }
        for(int j=0;j<values.length;j++){
            values[j][0]=0;
        }

            for(int j=1;j<values[0].length;j++){
                for(int i=1;i<values.length;i++){
                    if(j>=ints[i-1]) {
                        values[i][j]=Math.max(values[i-1][j],values[i-1][j-ints[i-1]]+prices[i-1]);
                    }else{
                        values[i][j]=values[i-1][j];
                    }
            }
        }
        return values[x-1][y-1];
    }
}
