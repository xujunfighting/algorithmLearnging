package com.zto.newYear;

import com.zto.algorithm.TreeNode;
import com.zto.common.DoubleLinkedList;

/**
 * Created by xujun on 2019-01-09.
 */
public class TreeConvertToListNode {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node6;
        node1.right=node3;
        node6.left=node4;
        node6.right=node5;
        node3.left=node8;
        node3.right=node9;
    }
    public void method(TreeNode node){
      DoubleLinkedList list=new DoubleLinkedList(node.getVal());

    }
}
