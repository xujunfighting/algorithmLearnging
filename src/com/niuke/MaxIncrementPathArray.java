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
    private static List<Integer> result = new ArrayList<>();
    private static int max=0;
    public static void main(String[] args) {

        int[][] res = new int[][]{{4, 3, 3, 6, 6, 3, 2, 1, 0, 7}, {1, 8, 2, 8, 5, 9, 2, 8, 3, 1}, {8, 0, 9, 2, 4, 3, 2, 4, 3, 7}, {1, 2, 2, 6, 3, 0, 3, 9, 7, 0}, {7, 4, 3, 8, 8, 3, 2, 4, 6, 8}, {2, 8, 9, 2, 9, 3, 0, 8, 7, 8}, {8, 9, 9, 4, 6, 3, 3, 4, 9, 6}, {2, 8, 3, 8, 1, 3, 7, 3, 0, 7}, {2, 1, 1, 6, 4, 1, 0, 8, 1, 6}, {4, 1, 3, 6, 3, 4, 4, 4, 0, 3}};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                list=new ArrayList<>();
                list.add(res[i][j]);
                result = new ArrayList<>();
                getMethod(res,i,j,list);
                if(result.size()>max){
                    max=result.size();
                }
            }
        }
        System.out.println(max);
}

    public static void getMethod(int[][] res,int x,int y,List<Integer> list){

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
