package com.zto.algorithm;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xujun on 2018-10-22.
 */
public class TreeNodeVistTest {

    public static void main(String[] args){
          TreeNode n1=new TreeNode(1);
          TreeNode n2=new TreeNode(2);
          TreeNode n3=new TreeNode(3);
          TreeNode n4=new  TreeNode(4);
          TreeNode n5=new TreeNode(5);
          TreeNode n6=new TreeNode(6);
          n1.left=n2;
          n1.right=n6;
          n2.right=n3;
          n3.left=n4;
          n3.right=n5;
        layerOrder(n1);
    }
    public static  void preTree(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.getVal());
        preTree(node.left);
        preTree(node.right);
    }
    public static void backTree(TreeNode node){
        if(node==null){
            return;
        }
        backTree(node.left);
        backTree(node.right);
        System.out.println(node.getVal());
    }
    public static void preTree1(TreeNode node){
       Stack<TreeNode> stack=new Stack<>();
       boolean state=false;
       while(!stack.isEmpty()||state==false) {
           state=true;
           while (node != null) {
               System.out.println(node.getVal());
               stack.add(node);
               node = node.left;
           }
           TreeNode right=stack.pop();
           if(right.right!=null){
               node=right.right;
           }
       }

    }
    public static void middleTree(TreeNode node){
        if(node==null){
            return;
        }
        middleTree(node.left);
        System.out.println(node.getVal());
        middleTree(node.right);
    }
    public static void middleTree2(TreeNode node){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean state=false;
        while(!stack.isEmpty()||state==false) {
            state=true;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            TreeNode left = stack.pop();
            System.out.println(left.getVal());
            if (left.right != null) {
                node = left.right;
            }
        }
    }
    public static void backTree2(TreeNode node){

        Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean state=false;
        TreeNode current=null;
        while(!stack.isEmpty()||state==false){//state状态用于判断第一次队列为空的情况 保证程序进入第一个轮训遍历
            state=true;
            while(node!=null){//当左子树不为空情况下一直压栈 node每次都处于为空的状态
                stack.add(node);
                node=node.left;
            }
            TreeNode left=stack.peek();
            if(left.right!=null&&left.right!=current){//右子树没有遍历过的
                node=left.right;
            }else{
                TreeNode val=stack.pop();
                System.out.println(val.getVal());
                current=val;
            }
        }
    }
    public static void  layerOrder(TreeNode node){
        Queue<TreeNode> queen=new LinkedBlockingQueue<TreeNode>();
        queen.add(node);
        int count=0;//标记每层输出的元素
        int layerCount=0;//记录下一层的元素个数
        int tmp=1;//记录当前层的元素个数
        while(!queen.isEmpty()){
            TreeNode tree=queen.poll();
            System.out.print(tree.getVal());
            count++;
            if(tree.left!=null){
                queen.add(tree.left);
                layerCount++;
            }
            if(tree.right!=null){
                queen.add(tree.right);
                layerCount++;
            }
            if(count==tmp){
                tmp=layerCount;
                layerCount=0;
                count=0;
                System.out.println();
            }
        }
    }
}
