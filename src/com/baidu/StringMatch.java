package com.baidu;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/6
 */
public class StringMatch {
    public static void main(String[] args) {
        String string="3[abc]";
        String result = getResult(string);
        System.out.println(result);
    }
    public static String getResult(String str){
        String result="";

        StringBuffer stringBuffer=new StringBuffer();
        StringBuffer sb=new StringBuffer();
        boolean hasAdd=false;
        char[] arrays=str.toCharArray();
        Queue<Integer> counts=new ArrayBlockingQueue<Integer>(str.length());
        Queue<String> chars=new ArrayBlockingQueue<String>(str.length());
        Queue<Integer> levels=new ArrayBlockingQueue<Integer>(str.length());
        for(int i=arrays.length-1;i>=0;i--){

            if(arrays[i]>='1'&&arrays[i]<='9'){
                counts.add(Integer.valueOf(arrays[i]-'0'));
            }
            int level=1;
            hasAdd=false;
            if(arrays[i]==']') {
                while (i>0) {
                    i = i - 1;
                    if (arrays[i] == '[') {
                        chars.add(sb.toString());
                        sb=new StringBuffer();
                        i--;
                        break;
                    }
                    if (arrays[i] == ']') {
                        level++;
                        levels.add(level);
                        hasAdd=true;
                        continue;
                    }
                    sb.append(arrays[i]);
                }
                if(!hasAdd){
                    levels.add(level);
                }
            }else if(arrays[i]<='1'||arrays[i]>'9'){
                stringBuffer.append(arrays[i]);
            }

        }
        StringBuffer s=new StringBuffer();
        boolean hasSub=false;
        StringBuffer preSub=new StringBuffer();
        while (!counts.isEmpty()&&!chars.isEmpty()&&!levels.isEmpty()){
            int level=levels.poll();
            String string=chars.poll();
            int count=counts.poll();
            if(level==1){
                if(!hasSub) {
                    s = new StringBuffer();
                }else{
                    s=preSub;
                }
                hasSub=false;
                for(int i=0;i<count;i++){
                    s.append(string);
                }
                stringBuffer.append(s.toString());
            }else{
                for(int i=0;i<count;i++){
                    s.append(string);
                }
                preSub=s;
            }

        }
        result=stringBuffer.reverse().toString();
        return result;
    }
}
