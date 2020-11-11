package com.zto.offer;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2018-11-28.
 */
public class JudgeSubTree {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        TreeNode node33=new TreeNode(3);
        TreeNode node44=new TreeNode(6);
        TreeNode node55=new TreeNode(5);
        node33.left=node44;
        node33.right=node55;
        boolean result=method(node1,node33);
        System.out.print(result);
    }
    public static boolean method(TreeNode t1, TreeNode t2){
          boolean is_subTree=false;
            if(t1!=null){
                if(t1.getVal()==t2.getVal()){
                    is_subTree=judge(t1,t2);
                }
                if(is_subTree==false){
                    return method(t1.left,t2)||  method(t1.right,t2);
                }else{
                    return is_subTree;
                }
            }
            return is_subTree;
    }
    public static boolean judge(TreeNode n1,TreeNode n2){
        if(n2!=null&&n1==null){
            return false;
        }
        if(n2==null){
            return true;
        }
        if(n1.getVal()!=n2.getVal()){
            return false;
        }
        return judge(n1.left,n2.left)&&judge(n1.right,n2.right);
    }
}
