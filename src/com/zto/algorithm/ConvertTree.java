package com.zto.algorithm;

/**
 * Created by xujun on 2018-11-09.
 */
public class ConvertTree {
    private static TreeNode leftHead = null;
    private static TreeNode rightHead = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return  null;

        Convert(pRootOfTree.left);

        if (leftHead == null) {
            leftHead = pRootOfTree;
            rightHead = pRootOfTree;
        }
        else {
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return leftHead;
    }

    public static void main(String[] args){
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
         t1.left=t2;
         t2.left=t3;
         t1.right=t5;
         t5.left=t4;
         t5.right=t6;
         TreeNode result=Convert(t1);
         System.out.print("result");
    }
    public static TreeNode getResult(TreeNode node){
       if(node==null){
           return node;
        }
        TreeNode next=node;
        getResult(node.left);
         node.right=next;
         node.left=leftHead;
        getResult(node.right);
        return null;
    }
}
