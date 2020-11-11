package com.zto.newYear;


import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2019-01-25.
 */
public class IsBalanceTree {
    private static boolean isBalance=true;
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2 );
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.right=node6;
        int depth=0;
        boolean result=result(node1,depth);
        System.out.print(result);
    }
    public static int method(TreeNode node){
       if(node==null){
           return 0;
       }
       int left=method(node.left);
       int right=method(node.right);
       if(Math.abs(left-right)>1){
           isBalance=false;
       }
       return Math.max(left,right)+1;
    }
    public static boolean result(TreeNode node,int depth){
         if(node==null){
             depth=0;
             return true;
         }
         int left=0;
         int right=0;
         if(result(node.left,left)&&result(node.right,right)){
                depth=right>left?right+1:left+1;
                return true;
         }else{
             return false;
         }

    }
}
