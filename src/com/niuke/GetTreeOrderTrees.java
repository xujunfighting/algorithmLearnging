package com.niuke;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/29
 */
public class GetTreeOrderTrees {
    public static void main(String[] args) {
          TreeNode node1=new TreeNode(1);
          TreeNode node2=new TreeNode(2);
          TreeNode node3=new TreeNode(3);
          TreeNode node4=new TreeNode(4);
          TreeNode node5=new TreeNode(6);
          TreeNode node7=new TreeNode(7);
          TreeNode node8=new TreeNode(8);
          node1.left=node2;
          node1.right=node3;
          node2.left=node4;
          node2.right=node7;
          node3.right=node5;
          node3.left=node8;
          int[] res=backOrder(node1);
          print(res);
    }
    public static int[] middleOrder(TreeNode root){
        List<Integer> lists=new ArrayList<>();
        if(root==null){
            return null;
        }
        Stack<TreeNode> treeNodeStack=new Stack<>();
        while(root!=null||!treeNodeStack.isEmpty()){
            while(root!=null) {
                treeNodeStack.add(root);
                root=root.left;
            }
            TreeNode node=treeNodeStack.pop();
            lists.add(node.val);
            if(node.right!=null){
               root=node.right;
            }
        }
        int[] res=new int[lists.size()];
        for(int i=0;i<lists.size();i++){
            res[i]= lists.get(i);
        }
        return res;
    }
    public static int[] preOrder(TreeNode root){
        List<Integer> lists=new ArrayList<>();
        if(root==null){
            return null;
        }
        Stack<TreeNode> treeNodeStack=new Stack<>();
        while(root!=null||!treeNodeStack.isEmpty()){
            while(root!=null) {
                lists.add(root.val);
                if(root.right!=null){
                    treeNodeStack.add(root.right);
                }
                root=root.left;
            }
            if(!treeNodeStack.isEmpty()) {
                root = treeNodeStack.pop();
            }
        }
        int[] res=new int[lists.size()];
        for(int i=0;i<lists.size();i++){
            res[i]= lists.get(i);
        }
        return res;
    }
    public static int[] backOrder(TreeNode root){
        List<Integer> lists=new ArrayList<>();
        if(root==null){
            return null;
        }
        Stack<TreeNode> treeNodeStack=new Stack<>();
        TreeNode cur=null;
        while(root!=null||!treeNodeStack.isEmpty()){
            while(root!=null) {
                treeNodeStack.add(root);
                root=root.left;
            }
            TreeNode node=treeNodeStack.peek();
            if(node.right!=null&&node.left==cur){
                root=node.right;
            }else{
                cur=node;
                lists.add(node.val);
                treeNodeStack.pop();
            }
        }
        int[] res=new int[lists.size()];
        for(int i=0;i<lists.size();i++){
            res[i]= lists.get(i);
        }
        return res;
    }
    public static void print(int[] res){
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
