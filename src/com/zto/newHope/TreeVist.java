package com.zto.newHope;

import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author xujun
 * Create date 2019-06-05.
 * desc:
 */
public class TreeVist {
    private static TreeNode visisted=null;
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        layerVisit(node1);
    }
    public  static void preVisit(TreeNode node){
         if(node!=null){
             System.out.println(node.getVal());
             preVisit(node.left);
             preVisit(node.right);
         }
    }
    public static void preVisit1(TreeNode treeNode){
        Stack<TreeNode> stack=new Stack<>();
        while(treeNode!=null||stack.size()!=0){
            while(treeNode!=null) {
                System.out.println(treeNode.getVal());
                if(treeNode.right!=null){
                    stack.add(treeNode.right);
                }
                treeNode=treeNode.left;
            }
            if(stack.size()!=0) {
                treeNode = stack.pop();
            }
        }
    }
    public static void preVisit2(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null||stack.size()!=0){
            while(node!=null){
                System.out.println(node.getVal());
                stack.add(node);
                node=node.left;
            }
            TreeNode treeNode=stack.pop();
            if(treeNode.right!=null){
                stack.add(treeNode.right);
                node=treeNode.right;
            }
        }
    }
    public static void middleVisit(TreeNode node){
        if(node!=null){
            middleVisit(node.left);
            System.out.println(node.getVal());
            middleVisit(node.right);
        }
    }
    public static void middleVisit1(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.add(node);//左子树全部压栈
                node=node.left;
            }
            TreeNode treeNode=stack.pop();//节点出栈
            System.out.println(treeNode.getVal());
            if(treeNode.right!=null){
                stack.add(treeNode.right);
                node=treeNode.right.left;
            }
        }
    }
    public static void backVisit(TreeNode node){
        if(node!=null){
            backVisit(node.left);
            backVisit(node.right);
            System.out.println(node.getVal());
        }
    }
    public static void backVisit1(TreeNode node){
       Stack<TreeNode> stack=new Stack<>();
       while(node!=null||!stack.isEmpty()){
           while(node!=null){
               stack.add(node);
               node=node.left;
           }
           TreeNode tree=stack.peek();//弹出节点
           if(tree.right!=null&&visisted!=tree.right){
               node=tree.right;
           }else{
               tree=stack.pop();
               System.out.println(tree.getVal());
               visisted=tree;
           }
       }
    }
    public static void layerVisit(TreeNode node){
        Queue<TreeNode> queue=new LinkedBlockingQueue<TreeNode>();
        queue.add(node);
        int cur=1;
        int next=0;
        int count=0;
        while(!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            System.out.print(treeNode.getVal()+" ");
            count++;
            if(treeNode.left!=null){
                queue.add(treeNode.left);
                next++;
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
                next++;
            }
            if(count==cur){
                cur=next;
                count=0;
                next=0;
                System.out.println();
            }
        }
    }

}
