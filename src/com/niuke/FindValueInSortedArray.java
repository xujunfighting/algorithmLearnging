package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/9
 */
public class FindValueInSortedArray {
    public static void main(String[] args) {
           int[][] array=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
           int[] result = getResult(array, 3, 3, 12);
           System.out.println(result);
    }
    public static int[] getResult(int[][] array,int x,int y,int res){
                int[] result=new int[2];
                int startX=0;
                int startY=0;
                int endX=array.length;
                int endY=array[0].length;
                if(res<array[startX][startY]){
                      return result;
                }
                while(startX<endX&&startY<endY){
                    if(array[startX][startY]==res){
                        result[0]=startX;
                        result[1]=startY;
                        return result;
                    }
                    if(startX+1<endX&&res>array[startX][startY]&&res<array[startX+1][startY]
                    ||startX+1==endX){//结果在当前行 或者没有后继行元素
                        startY++;
                    }else{
                        startX++;
                    }
                }
                return result;
    }
}
