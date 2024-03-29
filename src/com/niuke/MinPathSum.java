package com.niuke;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/5/6
 **/
public class MinPathSum {
    private static List<Integer> lists=new ArrayList<>();
    private  static int result=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] arrays=new int[][]
                {{73,4,38,35,11,99,5,51,94,35,30,30,55,29,7,50,43,18,61,75,86,45,45,11,17,82,97,8,4,91,0,7,22,39,70,14,39,80,24,15,32,36,88,65,81,98,32},
                {98,21,2,71,40,68,48,48,93,48,64,49,14,53,8,4,81,25,16,40,15,28,27,52,63,50,85,93,29,66,22,94,63,53,9,58,78,51,77,69,7,31,86,87,56,66,79},
                {23,75,5,7,24,52,84,8,67,47,34,57,56,84,30,65,49,52,91,50,74,81,40,51,41,70,80,59,22,58,96,40,11,21,82,79,74,44,73,66,36,81,79,86,33,0,38},
                {6,33,91,7,69,63,24,27,82,81,77,21,68,76,14,49,53,20,86,48,85,95,75,16,18,16,52,98,60,5,50,99,96,3,46,62,20,50,47,6,46,28,40,93,51,94,59},
                {34,4,58,35,32,41,50,70,25,66,93,92,13,11,38,95,31,15,70,24,25,32,1,29,83,51,4,76,31,85,8,58,18,87,24,18,0,43,64,99,53,43,58,23,0,67,48},
                {50,0,5,28,71,13,14,71,78,80,55,34,56,75,32,16,83,51,43,80,60,6,32,6,9,67,68,38,16,48,63,85,2,39,6,43,25,97,35,39,56,59,92,82,59,49,94},
                {3,42,53,44,5,58,20,21,38,78,6,40,20,70,51,50,84,92,32,5,12,35,15,61,24,31,14,24,5,92,46,82,92,49,47,42,56,91,20,55,14,97,39,32,82,11,17},
                {73,84,90,62,72,17,45,87,40,36,64,52,53,68,73,5,36,38,5,0,86,100,31,70,2,62,19,51,24,40,37,24,23,48,36,97,42,60,44,5,76,50,80,87,40,71,16},
                {20,20,76,3,65,97,79,0,42,53,100,28,16,13,31,37,31,67,95,35,34,83,47,100,85,91,65,31,58,15,83,74,78,29,94,22,66,33,21,69,32,92,61,73,50,93,39},
                {44,69,0,80,11,100,43,66,7,84,11,46,15,14,70,90,30,75,27,20,33,64,84,87,50,18,96,76,20,86,48,90,83,13,1,52,74,16,87,12,3,91,80,69,78,73,64},
                {51,49,56,9,21,21,0,47,62,15,40,53,73,12,23,17,37,80,37,28,78,4,12,26,43,65,2,27,93,8,58,31,39,93,21,11,76,55,42,18,38,69,24,88,0,27,92},
                {82,20,96,58,43,98,18,25,5,34,10,15,0,48,89,84,86,96,34,80,72,51,87,56,68,7,91,96,89,30,15,77,30,46,4,0,0,58,44,59,56,1,59,71,42,19,11},
                {43,61,51,80,47,50,0,3,46,6,86,30,44,82,99,57,16,94,27,29,66,81,83,75,53,87,27,32,5,21,80,80,92,69,62,12,100,19,34,55,22,46,46,84,66,76,28},
                {6,26,7,43,8,53,68,63,28,74,29,31,99,55,94,44,99,62,77,16,62,51,57,100,97,82,86,54,10,60,60,16,0,48,3,38,34,27,91,16,49,96,81,86,35,78,61},
                {16,69,54,4,58,57,84,21,61,36,50,10,73,98,91,29,0,5,68,23,75,11,34,84,65,39,44,81,38,14,59,32,21,43,3,18,99,32,70,20,67,13,74,60,99,67,85},
                {72,2,24,21,25,79,17,84,10,22,88,88,4,57,94,25,96,58,66,72,84,8,68,52,0,96,24,34,19,24,81,29,21,28,79,64,9,46,0,80,85,53,14,89,85,6,34},
                {95,25,93,47,75,10,19,96,41,66,6,85,75,91,47,63,87,86,75,13,77,5,11,35,73,48,60,51,83,44,44,90,46,96,78,27,89,97,90,45,89,43,10,39,25,6,10},
                {63,64,56,44,43,20,57,99,91,73,71,3,19,83,23,83,58,94,7,88,17,81,46,21,26,56,35,66,27,32,16,16,55,73,5,66,54,88,13,66,32,51,23,73,79,46,24},
                {19,11,23,42,27,60,86,85,71,57,83,45,17,61,17,28,79,33,64,76,38,2,93,76,68,46,71,75,99,38,98,99,63,47,9,66,89,59,18,65,8,77,53,50,76,50,76},
                {0,52,17,15,20,95,14,49,4,52,17,80,58,33,95,94,22,56,61,57,39,27,2,79,15,79,42,81,53,53,22,49,49,54,41,100,25,82,45,52,14,66,16,78,22,86,74},
                {8,44,84,50,53,79,35,67,33,99,0,69,69,38,4,88,7,34,33,93,78,52,43,81,51,73,4,9,22,9,93,38,54,25,43,33,19,59,62,18,19,20,79,22,30,7,84},
                {32,10,13,46,59,49,99,82,64,99,69,39,78,8,35,55,98,14,28,96,35,32,9,26,29,89,60,28,6,55,89,21,77,3,4,9,71,2,32,51,60,36,88,60,19,19,4},
                {43,18,49,96,58,31,70,93,35,17,82,27,8,14,54,91,34,77,30,42,8,39,56,16,25,79,61,45,81,71,94,36,88,56,96,29,7,49,6,10,15,54,37,15,11,86,78},
                {69,41,76,28,76,89,20,39,58,97,32,30,90,81,44,76,12,1,61,42,45,34,14,99,23,24,22,2,71,40,17,79,46,51,61,6,74,52,23,46,17,20,45,28,45,60,9},
                {2,32,47,37,17,5,6,39,19,36,25,62,54,31,31,64,14,56,87,43,42,47,9,52,78,37,79,22,16,68,82,36,11,3,31,2,79,17,3,91,93,23,93,7,53,12,10},
                {71,34,28,3,25,12,52,45,68,89,89,24,26,81,37,87,23,65,70,52,20,50,34,58,91,5,42,10,4,100,35,44,92,1,61,58,42,19,24,5,67,97,60,34,0,72,31},
                {1,49,33,0,4,53,77,57,50,22,46,98,5,32,97,39,45,24,4,63,61,2,42,6,35,68,33,5,36,99,10,10,12,39,84,85,93,37,0,92,6,20,10,57,24,40,3},
                {77,75,56,23,1,58,47,40,52,41,81,82,69,30,25,37,12,31,26,50,29,14,86,57,25,7,49,45,64,38,72,39,24,60,70,34,79,60,18,69,99,83,99,28,64,89,98},
                {35,15,75,95,41,40,46,19,39,83,33,7,13,67,40,78,79,0,82,35,26,0,93,94,86,92,63,55,17,19,69,63,87,96,22,57,89,47,50,34,38,59,71,41,9,89,38},
                {90,34,67,92,20,16,24,72,96,94,96,76,61,33,98,42,74,22,87,36,62,36,5,27,90,76,22,25,82,36,27,30,60,40,21,66,84,73,95,88,17,69,32,8,72,2,50},
                {34,59,44,11,29,80,68,47,52,5,40,13,2,59,68,97,49,62,23,32,38,8,95,35,14,41,75,12,77,4,66,27,86,85,15,60,71,84,98,12,1,43,56,19,17,93,59},
                {51,86,50,74,71,30,72,22,55,95,30,54,42,3,72,13,62,31,8,62,43,29,98,15,63,81,55,91,67,46,45,98,70,84,81,55,99,49,100,39,66,22,30,93,39,32,91},
                {32,48,83,76,56,100,90,33,1,47,8,29,18,68,95,52,38,79,27,11,54,49,92,21,88,78,100,18,41,76,37,33,51,44,0,37,90,64,84,23,30,84,77,52,18,67,73},
                {83,78,60,19,91,40,92,70,21,11,47,100,73,34,54,97,83,99,47,88,33,55,77,32,20,42,99,74,66,95,10,24,88,77,33,92,28,29,99,19,77,40,86,62,38,80,43},
                {21,68,62,31,38,52,14,38,48,36,24,10,0,77,66,94,79,64,24,55,75,56,23,32,27,69,64,18,44,70,96,69,93,58,34,24,99,35,36,59,0,67,86,50,62,90,14},
                {52,37,86,34,93,42,5,62,81,73,71,37,15,4,39,70,80,63,9,83,21,57,76,100,82,69,81,26,27,96,76,79,64,2,64,0,58,35,70,80,30,58,66,33,98,3,1},
                {46,61,44,40,55,4,2,80,46,2,36,85,44,96,87,58,17,48,41,71,33,61,62,59,19,54,33,89,59,37,5,14,50,91,30,6,28,1,78,11,68,84,93,2,11,8,72},
                {80,84,78,77,55,59,69,3,63,41,50,53,47,97,35,93,30,12,33,45,84,100,68,69,38,22,78,19,76,30,85,78,31,62,38,72,14,93,67,37,29,78,30,69,54,14,2},
                {39,23,22,19,14,67,20,69,11,57,35,54,99,51,73,31,81,38,40,59,64,2,46,43,24,73,12,28,64,31,98,39,68,85,1,86,87,4,62,21,15,10,42,31,88,38,93},
                {22,60,5,34,18,8,54,14,32,69,61,46,84,45,99,65,51,16,82,58,5,63,11,28,42,61,11,36,72,3,68,9,31,50,81,17,34,5,49,62,20,54,69,63,61,14,4},
                {61,1,59,28,25,33,21,41,23,64,48,88,36,42,33,34,11,19,32,89,94,96,2,82,99,78,96,85,67,52,9,95,74,28,1,90,41,32,92,23,63,12,10,73,43,38,96}};
//        if(arrays.length==1&&arrays[0].length==1){
//            System.out.println(arrays[0][0]);
//        }
//        lists.add(arrays[0][0]);
//        getResult(arrays,0,0);
        //System.out.println(result);
        int resultEnhance = getResultEnhance(arrays);
        System.out.println(resultEnhance);

    }
    public static void getResult(int[][] args,int curX,int curY){

        if(curX==args.length-1&&curY==args[0].length-1){
            lists.add(args[curX][curY]);
            int sum = getSum(lists);
            if(sum<result){
                result=sum;
            }
            return;
        }
        if(!(curX==0&&curY==0)&&curX<args.length&&curY<args[0].length){
            //添加元素
            lists.add(args[curX][curY]);
        }
        if(curX+1<args.length){
            curX++;
            getResult(args,curX,curY);
            curX--;
            lists.remove(lists.size()-1);
        }
        if(curY+1<args[0].length){
            curY++;
            getResult(args,curX,curY);
            curY--;
            lists.remove(lists.size()-1);
        }
    }
    private static int getSum(List<Integer> lists){
        Integer reduce = lists.stream().reduce(0, (t1, t2) -> {
            return t1 + t2;
        });
        return reduce;
    }
    public static int getResultEnhance(int[][] arrays){
        int[][] args=new int[arrays.length][arrays[0].length];
        args[0][0]=arrays[0][0];
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[0].length;j++){
                if(i==0&&j==0){
                    args[i][j]=arrays[i][j];
                }else if(i==0&&j>0){
                    args[i][j]=args[i][j-1]+arrays[i][j];
                }else if(i>0&&j==0){
                    args[i][j]=args[i-1][j]+arrays[i][j];
                }else{
                   args[i][j]=Math.min(args[i-1][j],args[i][j-1])+arrays[i][j];
                }

            }
        }
        return args[arrays.length-1][arrays[0].length-1];
    }
}
