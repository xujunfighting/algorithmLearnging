package com.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/26
 */
public class MaxIncrementPathArray {
    private static List<Integer> result=new ArrayList<>();
    public static void main(String[] args) {
        int[][] res=new int[][]{{1,2},{4,3}};
        List<Integer> list=new ArrayList<>();
        list.add(res[0][0]);
        getMethod(res,0,0,list);
        System.out.println(result);
    }
    public static void getMethod(int[][] res,int x,int y,List<Integer> list){
        //if(){} 递归跳出逻辑
        if(list.size()>result.size()){
            result=new ArrayList<>(list);
        }
        if(x+1<res.length&&res[x+1][y]>res[x][y]){
            x++;
            list.add(res[x][y]);
            getMethod(res,x,y,list);
            list.remove(list.size()-1);
            x--;
        }
        if(x-1>=0&&res[x-1][y]>res[x][y]){
            x--;
            list.add(res[x][y]);
            getMethod(res,x,y,list);
            list.remove(list.size()-1);
            x++;
        }
        if(y+1<res.length&&res[x][y+1]>res[x][y]){
            y++;
            list.add(res[x][y]);
            getMethod(res,x,y,list);
            list.remove(list.size()-1);
            y--;
        }
        if(y-1>=0&&res[x][y-1]>res[x][y]){
            y--;
            list.add(res[x][y]);
            getMethod(res,x,y,list);
            list.remove(list.size()-1);
            y++;
        }
    }
}
