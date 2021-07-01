package com.niuke.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/30
 **/
public class LongestNoDuplicateSubString {
    public static void main(String[] args) {
        //"tmmzuxt"
        String strs=new String("abcabcbb");
        int result  = getResultEnhance(strs);
        System.out.println(result);

    }
    public static int  getResult(String s){
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            /**
             * 双重for循环的判断
             */
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            /**
             * 判断当前结果是否是历史统计结果中的最大值 如果是替换最大值
             */
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
                return ans;
    }

    public static int getResultEnhance(String s){
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        int result=0;
        int cur=0;
        int end=0;
        int start=0;
        Map<Character,Integer> res=new HashMap<>();
        char[] chars = s.toCharArray();
       while(start<chars.length&&end<chars.length){
            if(!res.containsKey(chars[end])){
                res.put(chars[end],end);
                cur=end-start+1;
                if(cur>result){
                    result=cur;
                }
                end++;
            }else{
                int index=res.get(chars[end]);
                res.clear();
                if(cur>result){
                   result=cur;
                }
                start=index+1;
                end=start;
            }

        }
        return result;
        }

    /**
     * map占用内存过大 采用阿斯克码表统计
     */
    public static int getResultEnhance2(String s){
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        int result=0;
        int cur=0;
        int end=0;
        int start=0;
        int[] maps=new int[128];
        for(int i=0;i<maps.length;i++){
            maps[i]=-1;
        }
        char[] chars = s.toCharArray();
        while(start<chars.length&&end<chars.length){
            if(maps[chars[end]]==-1){
                maps[chars[end]]=end;
                cur=end-start+1;
                if(cur>result){
                    result=cur;
                }
                end++;
            }else{
                int index=maps[chars[end]];
                for(int i=0;i<maps.length;i++){
                    maps[i]=-1;
                }
                if(cur>result){
                    result=cur;
                }
                start=index+1;
                end=start;
            }

        }
        return result;
    }
    }



