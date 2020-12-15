package com.niuke;

public class RotateOrderArray {
    public static void main(String[] args) {
        int[][] array=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printOrder(array);
        System.out.println("执行完成");
    }

    public static void printOrder(int[][] array){

        int count=0;
        int endX=array.length;
        int startX=0;
        int endY=array[0].length;
        int startY=0;
        int indexX=0;
        int indexY=0;
        int index=0;
        int total=endX*endY;
        while(index<total){
            while((count%2==0)&&indexY<endY){

                System.out.print(array[indexX][indexY]+" ");//奇数行
                indexY++;
                index++;
            }
            while(count%2==1&&indexY>=startY){//偶数行
                System.out.print(array[indexX][indexY]+" ");
                indexY--;
                index++;
            }
            if(count%2==0) {
               endY--;
               indexX++;
               indexY--;
            }else{
                startY++;
                indexX--;
                indexY++;
            }

            while((count%2==0)&&indexX<endX){//奇数列
                System.out.print(array[indexX][indexY]+" ");
                indexX++;
                index++;
            }
            while(count%2==1&&indexX>=startX){//偶数列
                System.out.print(array[indexX][indexY]+" ");
                indexX--;
                index++;
            }
            if(count%2==0){
                indexY--;
                indexX--;
                endX--;
            }else{
                startX++;
                indexX++;
                indexY++;
            }
            count++;
        }
    }
}
