package com.niuke.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/13 07:42
 */
public class Flipgame {

    public static void main(String[] args) {
          int[] fornts=new int[]{1,2,4,4,7};
          int[] backs=new int[]{1,3,4,1,3};
        int result = getResult(fornts, backs);
        System.out.println(result);
    }

    public static int getResult(int[] fronts,int[] backs){
        int result=Integer.MAX_VALUE;
        Map<Integer,Integer> maps=new HashMap<>();
        boolean isContains=false;
        for(int i=0;i<fronts.length;i++){
            if(!maps.containsKey(fronts[i])){
                maps.put(fronts[i],1);
            }else{
                Integer count = maps.get(fronts[i]);
                maps.put(fronts[i],count+1);

            }
        }

        for(int i=0;i<backs.length;i++){
            /**
             * maps中包含当前元素
             */
            if(maps.containsKey(backs[i])){
                continue;
            }else{
                isContains=true;
                if(result>backs[i]){
                    result=backs[i];
                }
            }
        }
        if(isContains) {
            return result;
        }else{
            return 0;
        }
    }
}
