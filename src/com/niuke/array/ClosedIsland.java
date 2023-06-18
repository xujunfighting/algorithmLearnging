package com.niuke.array;

/**
 * 计算孤岛数量
 */
public class ClosedIsland {
    /**
     * 返回孤岛数量值
     */
    private static int totalCount=0;
    /**
     * 标记路径是否访问
     */
    private static int[][] tags=null;
    /**
     * 孤岛二维数组
     */
    private static int[][]  grids=null;
    public static void main(String[] args) {
        int[][] res=new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int result = getResult(res);
        System.out.println(result);
    }

    public static int getResult(int[][] grid){
        totalCount=0;
        if(grid.length==1||grid[0].length==1){
            return totalCount;
        }
        grids=grid;
        tags=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                /**
                 * 路径已经访问过 或节点为水区域  或者到达边界点
                 */
                if(tags[i][j]==1||grid[i][j]==1||i==grid.length-1||j==grid[0].length-1||i==0||j==0){
                    continue;
                }
                boolean res=find(i,j);
                /**
                 * 返回结果为true添加总数值
                 */
                if(res){
                    totalCount++;
                }
            }
        }

        return totalCount;

    }

    public static boolean find(int i, int j) {
        /**
         * 到达边界点 表明不是被水包围
         */
        if(i==0||j==0||i==grids.length-1||j==grids[0].length-1){
            return false;
        }
        /**
         * 到达水边界或已经访问过 直接返回true
         */
        if (grids[i][j] == 1 || tags[i][j] == 1) {
            return true;
        }
        tags[i][j] = 1;
        boolean a=true;
        boolean b=true;
        boolean c=true;
        boolean d=true;

        if (i + 1 < grids.length && grids[i + 1][j] == 0 && tags[i + 1][j] == 0) {
           a=find( i + 1, j);
        }
        if (j + 1 < grids[0].length && grids[i][j + 1] == 0 && tags[i][j + 1] == 0) {
           b=find(i, j + 1);
        }

        if (i - 1 >=0 && grids[i - 1][j] == 0 && tags[i - 1][j] == 0) {
            c=find(i - 1, j);
        }
        if (j - 1 >=0 && grids[i][j - 1] == 0 && tags[i][j - 1] == 0) {
            d=find(i, j - 1);
        }
        /**
         * 各个方向返回都是true 才表明是被水包围
         */
        return a&&b&&c&&d;
    }

}
