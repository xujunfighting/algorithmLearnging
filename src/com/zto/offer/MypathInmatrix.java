package com.zto.offer;

/**
 * Created by xujun on 2018-12-04.
 */
public class MypathInmatrix {
    public static void main(String[] args){
        String[][] chars=new String[][]{{"a","b","t","g"},{"c","f","c","s"},{"j","d","e","h"}};
        String[] strs=new String[]{"b","f","c","e"};
        boolean[][] visited=new boolean[3][4];
        boolean result=findPath(chars,strs,visited);
        System.out.print(result);
    }
    public static boolean findPath(String[][] chars,String[] strs,boolean[][] visited){
        int cols=chars[0].length;
        int lows=chars.length;
        String str=strs[0];
        boolean result=false;
        for(int i=0;i<lows;i++){
            for(int j=0;j<cols;j++){

               if(chars[i][j].trim().equals(str)&&visited[i][j]==false){
                   //result=coreHasPath(chars,i,j,strs,visited,0);
                   result=getResult(chars,i,j,strs,0,visited,result);
                   if(result==true) {

                       return result;
                   }
               }
               visited[i][j]=true;
            }
        }
        return result;
    }
    public static boolean getResult(String[][] chars,int rows,int cols,String[] strs,int i,boolean[][] visited,boolean result){

        if(i>=strs.length){
           return true;
        }
        if(!chars[rows][cols].trim().equals(strs[i])&&visited[rows][cols]!=true){
            return false;
         }
        boolean res=false;
         if(rows>=0&&rows<chars.length&&cols>=0&&cols<chars[0].length&&visited[rows][cols]!=true) {
            visited[rows][cols]=true;
            i++;
            res=getResult(chars, rows + 1, cols, strs, i,visited,result)||
            getResult(chars, rows, cols + 1, strs, i,visited,result)||
             getResult(chars, rows - 1, cols, strs, i,visited,result)||
            getResult(chars, rows, cols - 1, strs, i,visited,result);
            if(res!=true){
                visited[rows][cols] = false;
            }
         }
        return res;
    }
    private static boolean coreHasPath(String[][] chars,int rows,int cols,String[] strs,boolean[][] visited,int i) {
        if (i == strs.length) return true;
        boolean hasPath = false;
        if (rows>=0 && rows < rows && cols>=0 && cols<cols && !visited[rows][cols] && chars[rows][cols] == strs[i]) {
            i++;
            visited[rows][cols] = true;
            hasPath = coreHasPath(chars,rows-1,cols,strs,visited,i) ||
                    coreHasPath(chars,rows+1,cols,strs,visited,i) ||
                    coreHasPath(chars,rows,cols-1,strs,visited,i) ||
                    coreHasPath(chars,rows,cols+1,strs,visited,i);
            if (!hasPath) {
                visited[rows][cols] = false; //return hasPath回到上一层调用，curLength的值会自动回到上一层调用时的值
            }
        }
        return hasPath;
    }
    public static boolean myTest(String[][] chars,int i,int j,String[] strs,int start){
        if(start>=strs.length){
            return true;
        }
        return  false;
    }

}
