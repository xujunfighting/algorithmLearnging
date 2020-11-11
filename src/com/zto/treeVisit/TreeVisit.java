package com.zto.treeVisit;


import com.zto.common.TreeNode;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2019-04-03.
 * desc:
 */
public class TreeVisit {
    public static void main(String[] args) {
       TreeNode node1=new TreeNode(1);
       TreeNode node2=new TreeNode(2);
       TreeNode node3=new TreeNode(3);
       TreeNode node4=new TreeNode(4);
       TreeNode node5=new TreeNode(5);
       TreeNode node6=new TreeNode(6);
       node1.left=node2;
       node2.left=node3;
       node3.left=node4;
       node3.right=node5;
       node2.right=node6;
       backOrder1(node1);
    }
    public static void preOrder(TreeNode node){
      if(node==null){
          return;
      }
      System.out.print(node.value);
      preOrder(node.left);
      preOrder(node.right);
    }
    public static void  preOrder1(TreeNode node){
        Stack<TreeNode> nodes=new Stack<>();
        while(node!=null||!nodes.isEmpty()){
            while(node!=null){
                System.out.println(node.value);//遍历左子树
                nodes.add(node);
                node=node.left;
            }
            TreeNode tree=nodes.pop();
            if(tree.right!=null){
                nodes.add(tree.right);
                node=tree.right;
            }
        }
    }
    public static void middleOrder(TreeNode node){
        if(node!=null){
            middleOrder(node.left);
            System.out.println(node.value);
            middleOrder(node.right);
        }
    }
    public static void middleOrder1(TreeNode node){
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        while(node!=null||!nodes.isEmpty()){
            while(node!=null){
                nodes.add(node);//依次存储左子树节点
                node=node.left;
            }
            TreeNode tree=nodes.pop();//弹出栈中的第一个节点
            System.out.println(tree.value);
            if(tree.right!=null){
               node=tree.right;
            }
        }
    }
    public static void backOrder(TreeNode node)
    {
        if(node==null){
            return;
        }
        backOrder(node.left);
        backOrder(node.right);
        System.out.println(node.value);
    }
    public static void backOrder1(TreeNode node){
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        TreeNode current=null;
        while(node!=null||!nodes.isEmpty()){
            while(node!=null){
                nodes.add(node);
                node=node.left;
            }
            //node=nodes.pop();
            node=nodes.peek();//弹出栈头节点
            if(node.right!=null&&current!=node.right){
                //nodes.add(node.right);
                node=node.right;
            }else{
                node=nodes.pop();
                System.out.println(node.value);//当当前节点的左右子树都是为空
                current=node;
                node=null;
            }
        }
    }
}
