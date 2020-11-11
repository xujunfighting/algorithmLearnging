package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/29
 */
public class MaxStockProfit {
    public static void main(String[] args) {
        int[] res=new int[]{2,4,5,9,7,4};
        int result = getResult(res);
        System.out.println(result);
    }
    public static int getResult(int[] args){
        int result=0;
        for(int i=1;i<args.length;i++){
            result+=Math.max(0,args[i]-args[i-1]);
        }
        return result;
    }
}
