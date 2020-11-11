package com.middle;

import java.util.HashMap;
import java.util.Map;

public class AppearOneChar {
    Map<Character,Integer> maps=new HashMap<Character,Integer>();
    StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {

    }
    public void insertChar(char c){
        sb.append(c);
        if(maps.containsKey(c)){
            Integer integer = maps.get(c);
            maps.put(c,++integer);
        }else{
            maps.put(c,1);
        }
    }
    public char FirstAppearingOnce()
    {
        String s = sb.toString();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(maps.get(c)==1){
                return c;
            }
        }
        return '#';
    }
}
