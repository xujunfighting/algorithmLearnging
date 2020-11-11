package com.niuke;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/17
 */
public class PrintTree {
    public static void main(String[] args) {

    }
    public int[][] threeOrders (TreeNode root) {
       int[][] results=new int[3][];
       int[] res1=preOrder(root);
       int[] res2=preOrder(root);
       int[] res3=backOrder(root);
       return results;
    }
    public int[] preOrder(TreeNode root){
        int[] result=new int[10];
        return result;
    }
    public int[] middleOrder(TreeNode root){
        int[] result=new int[10];
        return result;
    }
    public int[] backOrder(TreeNode root){
         int[] result=new int[10];
         return result;
    }
}
