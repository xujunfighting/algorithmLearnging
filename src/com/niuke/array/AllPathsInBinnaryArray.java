package com.niuke.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/20
 **/
public class AllPathsInBinnaryArray {
    static int result=0;
    static List<Node> lists=new ArrayList<>();
    public static void main(String[] args) {
//        lists.add(new Node(1,1));
//        getResult(1,1,51,9);
        //1916797311
        int resultEnhance = getResultEnhance(51, 9);
        System.out.println(resultEnhance);
    }
    public static void  getResult(int startX,int startY,int m,int n){
        if(startX==m&&startY==n){
            result++;
            //printPath(lists);
            return;
        }

        if(startX<m) {
            startX++;
            //lists.add(new Node(startX, startY));
            getResult(startX, startY, m, n);
            //lists.remove(lists.size() - 1);
            startX--;
        }
        if(startY<n) {
            startY++;
            //lists.add(new Node(startX, startY));
            getResult(startX, startY, m, n);
            //lists.remove(lists.size() - 1);
            startY--;
        }
    }
    private static void printPath(List<Node> lists){
        int i=0;
        while(i<lists.size()-1){
            Node node = lists.get(i);
            i++;
            System.out.print("["+node.x+","+node.y+"]->");
        }
        Node node=lists.get(i);
        System.out.print("["+node.x+","+node.y+"]");
        System.out.println();
    }
    private static class  Node

    {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int getResultEnhance(int m,int n){
        int[][] nums=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    nums[i][j]=1;
                }else {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[m-1][n-1];
    }
}
