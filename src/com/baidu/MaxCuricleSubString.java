package com.baidu;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/12
 */
public class MaxCuricleSubString {
    private static int max=0;
    public static void main(String[] args) {
        String str="aba";
        int result = getResult(str);
        System.out.println(result);
    }
    public static int getResult(String strs){
        char[] chars = strs.toCharArray();
        int[][] res=new int[chars.length][chars.length];
         for(int i=0;i<res.length;i++){
             for(int j=0;j<res[0].length;j++){
                 if(i==j){
                     res[i][j]=1;
                 }
                 if(i==j+1&&chars[i]==chars[j]){
                     res[i][j]=2;
                 }
                 if(j<i&&chars[i]==chars[j]){
                     if(i-1>0) {
                         if(res[i-1][j+1]==0&&i-j>1){
                             continue;
                         }
                         res[i][j] = res[i - 1][j+1] + 2;
                     }
                     if(res[i][j]>max){
                         max=res[i][j];
                     }
                 }
             }
         }
         return max;
    }
}
