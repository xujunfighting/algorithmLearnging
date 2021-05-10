package com.niuke;

/**
 * @version v1.0.0
 * @Description
 * 查找最长回文子串
 * 题解：
 * 针对之前遍历过的元素的最大回文数在添加当前的遍历位置查看是否满足条件
 * 利用动态规划思想
 * 每个元素以自身为起始位置分别判断两边的内容是否相等
 * @Author xujun
 * @Since 1.0
 * @Date 2021/4/29
 **/
public class LongestPalindromicSubString {

    public static void main(String[] args) {
          String strs=new String("caac");
        int result = getResultEnhance(strs);
        System.out.println(result);
    }

    /**
     * 针对的是当前的字符串迭代判断并没有使用到之前的验证结果
     * 需要单独判断是奇数还是偶数串
     * @param strs
     * @return
     */
    public static int getResult(String strs){
      char[] chars=strs.toCharArray();
      int result=1;
      int[][] arrays=new int[chars.length][chars.length];
      for(int i=0;i<chars.length;i++){
          arrays[i][i]=1;
          arrays[0][i]=1;
      }
      for(int i=1;i<chars.length;i++){
           for(int j=i-1;j>=0;j--){
              if((2*i-j)<chars.length&&chars[j]==chars[2*i-j]){
                  arrays[i][j]=arrays[i][j+1]+2;
              }else {
                  arrays[i][j]=arrays[i][j+1];
              }
          }
           if(arrays[i][0]>result){
               result=arrays[i][0];
           }
      }
      return  result;
    }
    public static int getResultEnhance(String strs){
        char[] chars = strs.toCharArray();
        int result=0;
        int[][] arrays=new int[chars.length][chars.length];
        for(int i=0;i<chars.length;i++){
            arrays[i][i]=1;
        }
        for(int i=1;i<arrays.length;i++){
            for(int j=i-1;j>=0;j--){
                if(chars[i]==chars[j]){
                    if(j+1==i){
                        //相邻两个元素相等
                        arrays[i][j]=2;
                    }else if(arrays[i-1][j+1]>0){
                        arrays[i][j]=arrays[i-1][j+1]+2;
                    }
                }
                result=Math.max(result,arrays[i][j]);
            }
        }
        return result;
    }

}
