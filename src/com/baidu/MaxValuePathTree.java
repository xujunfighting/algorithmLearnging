package com.baidu;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/11
 */
public class MaxValuePathTree {
    private static int result=0;
    private static int max=Integer.MIN_VALUE;
    private static boolean isStarted=true;
    public static void main(String[] args) {
         TreeNode node1=new TreeNode(1);
         TreeNode node2=new TreeNode(-2);
         TreeNode node3=new TreeNode(3);
         node1.left=node2;
         node1.right=node3;
         getResult(node1);
        System.out.println(max);
    }
    public static void getResult(TreeNode node) {
        if (node != null) {
            getResult(node.left);
            int curValue = node.getVal();

            if (result <= 0 && curValue > 0) {//合计小于零 单值大于零
                result = curValue;
            } else if (result >= 0 && curValue > 0) { //合计大于零 单值小于零
                result = result + curValue;
            } else if (result <= 0 && curValue < 0) { //合计小于零 单值小于零
                //do nothing
            } else if (result > 0 && curValue < 0) { //合计大于零 单值小于零
                if (result + curValue >= 0) {
                    result = result + curValue;
                } else {
                    result = 0;
                }
            }
            if(isStarted){
                result=curValue;
                isStarted=false;
            }
            if (max < result) {
                max = result;
            }
            getResult(node.right);
        }
    }
}
