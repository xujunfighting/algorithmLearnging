package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/13
 */
public class UniquePaths {
    private static int result=0;
    public static void main(String[] args) {
      int res=method2(3,3);
        System.out.println(res);
    }
    public static int method(int m,int n){
        if(m<=1&&n<=1) return 0;
        getResult(m,n,1,1);
        return result;
    }
    public static int getResult(int m,int n,int startX,int startY){
       if(startX==m&&startY==n){
           result++;
           return result;
       }
       if((startX+1)<=m){
           startX++;
           getResult(m,n,startX,startY);
           startX--;
       }
       if((startY+1)<=n){
           startY++;
           getResult(m,n,startX,startY);
           startY--;
       }
       return result;
    }
    public static int method2(int m,int n){
        if(m<=1&&n<=1) return 0;
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            res[i][0]=1;
        }
        for(int j=0;j<n;j++){
            res[0][j]=1;
        }
        if(m>1&&n>1) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
}
