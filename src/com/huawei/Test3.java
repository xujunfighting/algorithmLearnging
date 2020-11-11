package com.huawei;

import java.util.Scanner;

public class Test3 {
    public static int result=0;
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int count=Integer.valueOf(scanner.nextLine());
//        int[][] res=new int[count][count];
//        int i=0;
//        while(i<count){
//            String[] s = scanner.nextLine().split(" ");
//            for(int j=0;j<s.length;j++){
//                res[i][j]=Integer.valueOf(s[j]);
//            }
//            i++;
//        }
       int[][] res=new int[][]{
                {3,2,1,-3},
                {1,-1,1,1},
                {1,1,-1,2},
                {-2,1,2,3},
        };
        getResult(res);
    }

    public static void getResult(int[][] res){
        int monX=0;
        int monY=0;
        int cX=0;
        int cY=0;
        int preMonX=0;
        int preMonY=0;
        boolean isFlag=true;
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(res[i][j]==-3){
                    monX=i;
                    monY=j;
                }
                if(res[i][j]==-2){
                    cX=i;
                    cY=j;
                }
            }
        }

         method(res,monX,monY,cX,cY,0);
        if(result>0){
            System.out.println(result);
        }else {
            System.out.println(-1);
        }
    }
    public  static void method(int[][] res,int x1,int y1,int x2,int y2,int max){
        if((x1+1==x2||x1-1==x2)){
            if(max>result){
                result=max;
            }
        }
        if((y1+1==y2||y1-1==y2)){
            if(max>result){
                result=max;
            }
        }

        if(res[x1][y1]==-1){
            return;
        }
        if(x1>x2&&res[x1-1][y1]!=-1){
            x1--;
            max+=res[x1][y1];
            method(res,x1,y1,x2,y2,max);
            max-=res[x1][y1];
            x1++;
        }
        if(x1<x2&&res[x1+1][y1]!=-1){
            x1++;
            max+=res[x1][y1];
            method(res,x1,y1,x2,y2,max);
            max-=res[x1][y1];
            x1--;
        }
        if(y1>y2&&res[x1][y1-1]!=-1){
            y1--;
            max+=res[x1][y1];
            method(res,x1,y1,x2,y2,max);
            max-=res[x1][y1];
            y1++;
        }
        if(y1<y2&&res[x1][y1+1]!=-1){
            y1++;
            max+=res[x1][y1];
            method(res,x1,y1,x2,y2,max);
            max-=res[x1][y1];
            y1--;
        }
    }
}
