package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-30.
 * desc:
 */
public class MoneyChoose {
    public static void main(String[] args) {
        int[] a=new int[]{1,3,5};
        int res=method(a,6);
        System.out.println(res);
    }
    public static int method(int[] a,int sum){
        int[][] b=new int[a.length+1][sum+1];
//        for(int i=0;i<=sum;i++){
//            b[0][i]=1;
//        }
        for(int j=0;j<a.length;j++){
            b[j][0]=1;
        }
        int j=0;
        int i=0;
        for(i=1;i<b.length;i++){
            for(j=1;j<b[0].length;j++){
                for(int k=0;k<=j/a[i-1];k++)
                b[i][j]+=b[i-1][j-a[i-1]*k];
            }
            System.out.println("current"+i);
        }
        return b[a.length][sum];
    }
}
