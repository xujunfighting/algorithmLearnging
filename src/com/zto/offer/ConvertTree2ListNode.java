package com.zto.offer;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2018-12-06.
 */
public class ConvertTree2ListNode {
    private  static TreeNode head=null;
    private  static TreeNode tail=null;
    public static void main(String[] args){
        TreeNode n4=new TreeNode(4);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(8);
        TreeNode n9=new TreeNode(9);
        n4.left=n2;
        n2.left=n1;
        n2.right=n3;
        n4.right=n5;
        n5.right=n6;
        n6.right=n8;
        n8.left=n7;
        n8.right=n9;
        TreeNode node=getListNode(n4);
        printTree(node);
    }
    public static TreeNode getListNode(TreeNode node){
        if(node!=null) {
            getListNode(node.left);
            if(head==null){
               head=node;
               tail=node;
            }else{

                tail.right=node;
                node.left=tail;
                tail=node;
            }
            getListNode(node.right);
        }
       return head;
    }
    public static void printTree(TreeNode node){
        while(node!=null){
            System.out.print(node.getVal()+" ");
            node=node.right;
        }
    }
}
