package com.leetcode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/14
 */
public class MoneyChoose {
    public static void main(String[] args) {
         int[] numbers=new int[]{2,3,5};
        int result = getResult(numbers, 2);
        System.out.println(result);
    }
    public static int getResult(int[] numbers,int sum){
        int[][] array=new int[numbers.length+1][sum+1];
        for(int i=0;i<array.length;i++){
            array[i][0]=1;
        }
        //1和5*1   6和5*0
        for(int i=1;i<array.length;i++){
            for(int j=1;j<array[0].length;j++){
                for(int k=0;k<=j/numbers[i-1];k++){
                   array[i][j]+=array[i-1][j-numbers[i-1]*k];
                }
            }
        }
        return array[numbers.length][sum];
    }

}
