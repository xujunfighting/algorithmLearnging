package com.niuke.array;



/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/8/12
 **/
public class FindWordExistsInArray {

    public static void main(String[] args) {
      char[][] chars= {{'C','A','A'},{'A','A','A'},{'B','C','D'}};

        String abcb = new String("AAB");
        /**
         * 数组访问标记为判断这个节点是否访问过
         */
        int[][] visited=new int[chars.length][chars[0].length];
        boolean abcced = isExists(chars, abcb,visited);

        System.out.println(abcced);

    }
    public static boolean isExists(char[][] chars,String word,int[][] visited){
        if(chars.length*chars[0].length<word.length()){
            /**
             * 二维字符数组的总体元素个数小于字符串的元素个数表明结果不存在直接返回错误
             */
            return false;
        }
        boolean isExists=false;
        char[] words=word.toCharArray();
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[0].length;j++){
                if(chars[i][j]==words[0]){
                    boolean result=findOthers(chars,i,j,words,0,visited);
                    /**
                     * 当查找到结果 就直接返回
                     */
                    if(result==true){
                        return true;
                    }
                    visited[i][j]=0;
                }
            }
        }
        return isExists;
    }
    public static boolean findOthers(char[][] chars,int startI,int startJ,char[] words,int start,int[][] visited){
        if(start>=words.length-1&&chars[startI][startJ]==words[start]){
            /**
             * 判断到最后一位且相等是表明结果正确
             */
            return true;
        }
        if(chars[startI][startJ]!=words[start]){
            /**
             * 当前节点和数组需要遍历的元素不相等直接返回错误
             */
            return false;
        }


        boolean isExists1=false;
        boolean isExists2=false;
        boolean isExists3=false;
        boolean isExists4=false;
        visited[startI][startJ]=1;
        if(startI==0||startI<chars.length-1){
            if(startI+1<chars.length&&chars[startI+1][startJ]==words[start+1]&&visited[startI+1][startJ]!=1){
               isExists1=findOthers(chars,startI+1,startJ,words,start+1,visited);
                visited[startI+1][startJ]=0;
            }
        }
        if(startJ==0||startJ<chars[0].length-1){
            if(startJ+1<chars[0].length&&chars[startI][startJ+1]==words[start+1]&&visited[startI][startJ+1]!=1){
               isExists2=findOthers(chars,startI,startJ+1,words,start+1,visited);
                visited[startI][startJ+1]=0;
            }
        }
        if(startI==chars.length-1||startI>0){
            if(startI-1>=0&&chars[startI-1][startJ]==words[start+1]&&visited[startI-1][startJ]!=1){
                isExists3=findOthers(chars,startI-1,startJ,words,start+1,visited);
                visited[startI-1][startJ]=0;
            }
        }
        if(startJ==chars[0].length-1||startJ>0){
            if(startJ-1>=0&&chars[startI][startJ-1]==words[start+1]&&visited[startI][startJ-1]!=1){
                isExists4=findOthers(chars,startI,startJ-1,words,start+1,visited);
                visited[startI][startJ-1]=0;
            }
        }

        return isExists1||isExists2||isExists3||isExists4;
    }
}
