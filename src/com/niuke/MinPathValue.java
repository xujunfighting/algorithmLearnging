package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/4
 */
public class MinPathValue {
    public static void main(String[] args) {
      int[][] res=new int[][]{{1,2},{5,6},{1,1}};
        int result = getResult(res);
        System.out.println(result);

    }
    public static int getResult(int[][] res){
        int x=res.length;
        int y=res[0].length;
        int[][] indexs=new int[x+1][y+1];
        for(int i=1;i<indexs.length;i++){
            for(int j=1;j<indexs[0].length;j++){
                if(indexs[i-1][j]==0){
                    indexs[i][j]=indexs[i][j-1]+res[i-1][j-1];
                }else if(indexs[i][j-1]==0){
                    indexs[i][j]=indexs[i-1][j]+res[i-1][j-1];
                }else{
                    indexs[i][j]=Math.min(indexs[i-1][j],indexs[i][j-1])+res[i-1][j-1];
                }
            }
        }
        return indexs[indexs.length-1][indexs[0].length-1];
    }
}
