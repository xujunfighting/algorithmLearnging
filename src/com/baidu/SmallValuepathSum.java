package com.baidu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/7
 */
public class SmallValuepathSum {
    private static List<Integer> values=new ArrayList<>();
    private static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
       int[][] arrays=new int[][]{{1,3,1,2},{1,5,1,3},{4,2,1,3}};
       values.add(arrays[0][0]);
       getResult(arrays,0,0);
        System.out.println(min);
    }
    public static void getResult(int[][] arrays,int x,int y){
        if(x==arrays.length-1&&y==arrays[0].length-1){
             int i=getValue(values);
            if(i<min){
                min=i;
            }
        }
        if(y<arrays[0].length-1){
            y++;
            values.add(arrays[x][y]);
            getResult(arrays,x,y);
            values.remove(values.size()-1);
            y--;
        }
        if(x<arrays.length-1){
            x++;
            values.add(arrays[x][y]);
            getResult(arrays,x,y);
            values.remove(values.size()-1);
            x--;
        }
    }
    public static int getValue(List<Integer> lists){
        int result=0;
        for(int value:lists){
            result+=value;
        }
        return result;
    }
}
