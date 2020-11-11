package com.zto.newHope;

/**
 * Author xujun
 * Create date 2019-06-20.
 * desc:
 */
public class MoneyChoose {
    public static void main(String[] args) {
       int[] res=new int[]{1,2,5};
       int result=getResult(res,12);
        System.out.println(result);
    }
    public static int getResult(int[] num,int res){
        int[][] v=new int[num.length+1][res+1];
        for(int i=0;i<v.length;i++){
            v[i][0]=1;
        }
        int j=0;
        int i=0;
        int k=0;
        for(i=1;i<v.length;i++){
            for(j=1;j<v[0].length;j++){
                for(k=0;k<=j/num[i-1];k++) {
                    v[i][j] += v[i - 1][j - k * num[i - 1]];
                }
            }
        }
        return v[num.length][res];
    }
}
