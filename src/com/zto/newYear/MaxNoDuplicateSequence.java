package com.zto.newYear;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujun on 2019-01-21.
 */
public class MaxNoDuplicateSequence {
    public static void main(String[] args) {
        String str=new String("1231234");
        int len=method(str);
        System.out.print(len);
    }
    public static int method(String sequence){
        char[] chars=sequence.toCharArray();
        Map<Character,Integer> maps=new HashMap<Character,Integer>();
        int current=0;
        int maxLength=0;
        for(int i=0;i<chars.length;i++){
            if(maps.containsKey(chars[i])){
                current=maps.get(chars[i])+1;
            }else{
               int len=i-current+1;
               if(len>maxLength){
                   maxLength=len;
               }
            }
            maps.put(chars[i],i);
        }
        return maxLength;
    }
}
