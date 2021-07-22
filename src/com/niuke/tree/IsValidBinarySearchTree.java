package com.niuke.tree;

import com.zto.algorithm.TreeNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/22
 **/
public class IsValidBinarySearchTree {
    /**
     * 用于记录以当前节点作为根节点的左子树的最大值 和右子树的最小值
     */
    static int[] res=new int[3];
    public static void main(String[] args) {

    }
    public static boolean getResult(TreeNode node){
        if(node==null){
            return true;
        }
        if(node.left==null&&node.right==null){
            res[0]=node.val;
            res[1]=node.val;
            res[2]=node.val;
            return true;
        }
        int val=node.val;
        boolean left=getResult(node.left);
        int leftL=res[0];
        int leftR=res[1];
        boolean right=getResult(node.right);
        int rightL=res[0];
        int rightR=res[1];
        if(left&&right){
            if(le)
        }else{
            return false;
        }
    }
}
