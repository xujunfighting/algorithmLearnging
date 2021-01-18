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
       int[][] res=new int[][]{{1,1,0,0,0},{0,1,0,1,1},{0,0,0,1,1},{0,0,0,0,0},{0,0,1,1,1}};
        temp=new int[res.length][res[0].length];
        getNum(res);
    }
    public static void getNum(int[][] res){
        while(startX!=res.length&&startY!=res[0].length){
            getResult(res,startX,maxY);
            getResult(res,maxX,startY);
        }
    }
    public static int  getResult(int[][] res,int curX,int curY){

        if(res[curX][curY]==0) {
            if (temp[startX][startY] <1){//没有设置过记录值
                temp[startX][startY]=1;
                result++;
            }
            return result;
        }
        if(res[curX][curY]==1&&curX+1<res.length){
            curX++;
            getResult(res,curX,curY);
            curX--;
        }
        if(res[curX][curY]==1&&curY+1<res[0].length){
            curY++;
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
