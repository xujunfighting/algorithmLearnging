package com.zto.newYear;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xujun on 2019-01-16.
 */
public class Fun {
    private AtomicInteger atomicInteger;
    public static int maxLenthNoRepeat(String str){
        if(str==null || str.isEmpty()){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int current = 0;

        //循环字符串，取出每个字符
        for(int index=0; index < str.length(); index++){
            if(map.containsKey(str.charAt(index))){
                current = map.get(str.charAt(index)) + 1;
            }else{
                if((index-current+1)>maxLength){
                    maxLength=index-current+1;
                }
            }
            map.put(str.charAt(index), index);
        }

        return maxLength;
    }
    public static void main(String[] args){
        String a="abccd";
        System.out.print(maxLenthNoRepeat(a));
    }
}

