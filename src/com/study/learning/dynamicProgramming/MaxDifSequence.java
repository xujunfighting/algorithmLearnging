package study.learning.dynamicProgramming;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class MaxDifSequence {
    public static void main(String[] args) {
        String seq="abba";//dvde
        int res=getResult2(seq);
        System.out.println(res);
    }

    private static int getResult(String str) {
        int len = str.length();
        int[] pos = new int[26];//记录出现过的字符在str中的位置
        for (int i = 0; i < 26; i++) {
            pos[i] = -1;
        }
        int pre = 0;//当前字符的前一个字符作为子串最后一位所能构成的不重复最长子串长度。
        int max = 0;//最大不重复子串
        int currLen = 0;//当前字符作为子串最后一位所能构成的不重复子串长度。
        for (int i = 0; i < len; i++) {
            int curr = str.charAt(i) - 'a';//计算当前的asc码值
            if (pos[curr] == -1 || pos[curr] < (i - pre)) {
                currLen = pre + 1;
            } else {
                currLen = i - pos[curr];
            }
            max = Math.max(max, currLen);
            pre = currLen;
            pos[curr] = i;
        }
        return max;
    }
    private static int getResult1(String str){
        int res=0;
        int max=0;
        int index=0;
        Map<Character,Integer> set= new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(set.containsKey(str.charAt(i))){
                 res=set.size();
                 set.clear();
                 set.put(str.charAt(i),i);
            }else{
                set.put(str.charAt(i),i);
                res=set.size();
            }
            if(max<res){
                max=res;
            }
        }
        return max;
    }
    private static int getResult2(String s){
        if (s.length()==0||s.length()==1) return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }


}
