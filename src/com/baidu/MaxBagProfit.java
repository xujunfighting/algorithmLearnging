package com.baidu;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/10
 */
public class MaxBagProfit {
    public static void main(String[] args) {
        int result = getResult();
        System.out.println(result);
    }
    public static int getResult(){
            int [] good_w = {2,2,6,5,4};  //商品重量
            int [] good_v = {6,3,5,4,6}; //商品价值
            int m = 10; //背包容量
            int number = 5;//商品数量
            //初始化二位数组
            int c[][] = new int[number+1][m+1];
            //二维数组第一行第一列填充值0
            for (int i = 0; i < c.length; i++) {
                c[i][0] = 0;
            }
            for (int i = 0; i < c[0].length; i++) {
                c[0][i] = 0;
            }
            //二维数组遍历
            for (int i = 1; i < c.length; i++) {
                for (int wj = 1; wj < c[0].length; wj++) {
                    if(good_w[i-1]>wj){
                        //装不下
                        c[i][wj] = c[i-1][wj];
                    }else{
                        //在装和不装中寻求最优解，取装和不装的最大值
                        c[i][wj] = Math.max(c[i-1][wj], c[i-1][wj-good_w[i-1]]+good_v[i-1]);
                    }
                }
            }
            return c[number][m];
        }
    }

