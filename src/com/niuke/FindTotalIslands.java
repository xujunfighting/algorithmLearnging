package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/15
 */
public class FindTotalIslands {
    public static int[][] temp;
    public static int startX=0;
    public static int startY=0;
    public static int result=0;
    public static int maxX=0;
    public static int maxY=0;
    public static void main(String[] args) {
       int[][] res=new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        temp=new int[res.length][res[0].length];
        getNum(res);
        System.out.println(result);
    }
    public static void getNum(int[][] res){
       for(int i=0;i<res.length;i++){
           for(int j=0;j<res[0].length;j++){
               if((i==0||j==0)&&res[i][j]==1&&temp[i][j]==0) {//第一个不为0的节点
                   getResult(res, startX, startY);
               }else if(i>=1&&j>=1&&temp[i][j]==0&&res[i-1][j-1]!=1&&res[i-1][j]!=1&&res[i][j-1]!=1&&res[i][j]==1){
                   startX=i;
                   startY=j;
                   getResult(res,startX,startY);
               }
           }
       }


    }
    public static int  getResult(int[][] res,int curX,int curY){

        if(res[curX][curY]==0||(curX==res.length-1&&curY==res[0].length-1)) {
            if (temp[startX][startY] <2){//没有设置过记录值
                temp[startX][startY]=2;
                result++;
            }
            return result;
        }
        if(res[curX][curY]==1&&curX+1<res.length){
            curX++;
            temp[curX][curY]=1;//记录节点是否访问过
            getResult(res,curX,curY);
            curX--;
        }
        if(res[curX][curY]==1&&curY+1<res[0].length){
            curY++;
            temp[curX][curY]=1;//记录节点是否访问过
            getResult(res,curX,curY);
            curY--;
        }
        if(curX>maxX) {
            maxX = curX + 1;
        }
        if(curY>maxY) {
            maxY = curY + 1;
        }
        return result;
    }
}
